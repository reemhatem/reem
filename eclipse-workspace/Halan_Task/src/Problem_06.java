import java.util.Arrays;

public class Problem_06 {
	
	public static void main(String[] args) {
		int[][] test1 = new int[][] {{1,2}, {3,4}};
		int [][] test1_result = transpose(test1);
		int [][] test2 = new int[][] {{1,2,3,4}, {5,6,7,8}};
		int [][] test2_result = transpose(test2);
		
		print2D(test1_result);
		System.out.println();
		print2D(test2_result);
	}
	
	public static int[][] transpose(int[][] input) {
		// Create a 2D output array of int depending on the dimensions of the input matrix
		int[][] output = new int[input[0].length][input.length];
		// Loop through the input matrix
		for(int i=0; i<input.length; i++) {
			for(int j=0; j<input[i].length; j++) {
				// Do the transpose step
				output[j][i] = input[i][j];
			}
		}
		return output;
	}
	
    public static void print2D(int mat[][]) 
    { 
        // Loop through all rows 
        for (int[] row : mat) 
            // converting each row as string 
            // and then printing in a separate line 
            System.out.println(Arrays.toString(row)); 
    } 
}
