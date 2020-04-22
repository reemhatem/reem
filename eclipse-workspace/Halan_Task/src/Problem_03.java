import java.util.Collections;
public class Problem_03 {
	
	public static void main(String[] args) {
		String encodedString = runLengthEncode("aaaaaaaaaabbbaxxxxyyyzyx");
		System.out.println("Encoded String: " + encodedString);
		String decodedString = runLengthDecode("a10b3a1x4y3z1y1x1");
		System.out.println("Decoded String: " + decodedString);
	}
	
	public static String runLengthEncode(String input){
		String output = "";
		char currentChar = input.charAt(0);
		int count = 0;
		StringBuilder sb = new StringBuilder();
		
		// Loop through input characters 
		for(int i = 0; i < input.length(); i++){
			// Checks if the current character is still unchanged
			if(currentChar == input.charAt(i))
				count++;	
			else{
				output = sb.append(currentChar).append(count).toString();
				count  = 1;
				currentChar = input.charAt(i);
			}
		}
		// Append the last character and it's count
		output = sb.append(currentChar).append(count).toString();
		return output;
	}
	
	public static String runLengthDecode(String input){
		String output = "";
		String repeatedChars = "";
		int count = 0;
		char currentChar = input.charAt(0);
		StringBuilder sb = new StringBuilder();
		int i = 0;
		
		// Loop through input string characters
		while(i < input.length()){
			// Check if current character is a letter or digit
			if(Character.isLetter(input.charAt(i))) {
				currentChar = input.charAt(i);
				i++;
			} else {			/* If current character is a digit */
				count += Integer.parseInt(String.valueOf(input.charAt(i)));
				int j = i+1;
				// Check if this is the last integer in turn, if not we append it to the previously found digit
				while(j<input.length() && Character.isDigit(input.charAt(j))) {
					count = (count*10) + Integer.parseInt(String.valueOf(input.charAt(j)));
					j++;
				}
				// Append the sequence of decoded characters to the output
				repeatedChars = String.join("", Collections.nCopies(count, String.valueOf(currentChar)));
				output = sb.append(repeatedChars).toString();
				count = 0;	
				i = j;
			}
		}
		return output;
	}

}