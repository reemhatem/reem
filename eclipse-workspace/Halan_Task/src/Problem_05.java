import java.util.Arrays;
import java.util.HashSet;

public class Problem_05 {
	public static void main(String[] args) {
		String[] input1 = new String[]{"apples","oranges","flowers","apples"};
		HashSet<String> output1 = unique(input1);
		System.out.println(Arrays.toString(output1.toArray()));
		
		String[] input2 = new String[]{"apples","apples"};
		HashSet<String> output2 = unique(input2);
		System.out.println(Arrays.toString(output2.toArray()));
		
	}
	public static HashSet<String> unique(String[] input){
        HashSet<String> set = new HashSet<>(); 
        // Loop through the input
        for(int i=0; i<input.length; i++) {
    		// Add unique items to set if it's not in there and discard the duplicated items
	    		if(set.contains(input[i])) {
	    			set.remove(input[i]);
	    		} else 
	    			set.add(input[i]);
        }   
		return set;
	}
}
