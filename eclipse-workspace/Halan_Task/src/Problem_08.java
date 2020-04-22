import java.util.HashSet;

public class Problem_08 {
	
	public static void main(String[] args) {
		int [] test = new int[] { 5, 17, 3, 17, 4, -1 };
		int result = index_of_first_duplicate(test);
		
		System.out.println(result);
	}
	
	// Runtime and space complexity of O(n)
	public static int index_of_first_duplicate(int[] input) {
		// Index of first repeated integer
		int first_duplicate_index = -1;
		// Initialize an empty set to keep track of unique integer values
        HashSet<Integer> set = new HashSet<>(); 
        // Loop through input array
        for(int i=0; i<input.length; i++) {
        		// Add item to set if it's not in there and trigger the first duplicated value, then find it's index
        		if(set.contains(input[i])) {
        			first_duplicate_index = i;
        			return first_duplicate_index;
        		} else 
        			set.add(input[i]);
        }     
        return first_duplicate_index;
	}
}