
public class Problem_01 {
	public static void main(String[] args) {
		System.out.println(palindrome("anna"));
		System.out.println(palindrome("apple"));
		System.out.println(palindrome("madam"));
	}
	
	public static Boolean palindrome(String input){
		// First pointer from the end
		int j = input.length()-1; 
		// Loop through half of the string and compare the chars 
		for(int i = 0; i < input.length()/2; i++){
			if(input.charAt(i) == input.charAt(j)){
				j--;
			} else
				return false;
		}
		return true;
	}
}
