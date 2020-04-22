import java.util.LinkedList;
import java.util.Queue;

public class Problem_09 {
	
	public static void main(String[] args) {
	    Node root = new Node(1); 
	    Node child1 = new Node(2);
	    Node child2 = new Node(3);
	    Node child3 = new Node(4);
	    Node child4 = new Node(5);
	    Node child5 = new Node(6);
	    Node child6 = new Node(7);
	    Node child7 = new Node(8);
	    Node child8 = new Node(9);
	    Node child9 = new Node(10);

	    root.children = new Node[] {child1,child2, child3, child4}; 
	    root.children[0].children = new Node[]{child5,child6};
	    root.children[1].children = new Node[]{child7};
	    root.children[2].children = new Node[]{child8,child9};

	  
	    System.out.print(treeSum(root) +"\n"); 
	}
	
	public static int treeSum(Node tree) {
		int sum = 0;
		// Check if this tree is null
		if(tree.value == null)
			return 0;
		// Create a Queue to add the tree
		Queue<Node> treeQueue = new LinkedList<>();
		treeQueue.add(tree);
		// Loop through the queue
		while(!treeQueue.isEmpty()) {
			int size = treeQueue.size();
			
			while(size>0) {
				Node node = treeQueue.peek(); 	// get the first item in the queue
				treeQueue.remove(); 				// dequeue 
				sum += node.value;				// add it's value to the sum
				// Checks that none of the children are null and enqueue the children to the queue
				if(node.children!=null) {
					for(int i = 0; i<node.children.length; i++) {
						treeQueue.add(node.children[i]);
					}
				}
				size--;
			}
		}
		return sum;
	}
}

class Node {
	public Node(int value) {
		this.value = value;
	}
	
	public Integer value;
	public Node[] children;
}