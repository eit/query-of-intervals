import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTree {
	private Node root;
	private int NodeCount = 0;
	
	public void insert(int value) {
		Node node = new Node(value);

		if (root == null) {
			root = node;
			return;
		}

		insertRec(root, node);
		NodeCount++;
	}

	private void insertRec(Node latestRoot, Node node) {

		if (latestRoot.value > node.value) {

			if (latestRoot.left == null) {
				latestRoot.left = node;
				return;
			} else {
				insertRec(latestRoot.left, node);
			}
		} else {
			if (latestRoot.right == null) {
				latestRoot.right = node;
				return;
			} else {
				insertRec(latestRoot.right, node);
			}
		}
	}
	


	public void balance()
	{
	   if ( NodeCount <= 1 ) return;

	   // STRIP ITEMS FROM TREE AS LIST

	   {//Taking advantage of Java's generic collections
	      Deque<Node> stack = new ArrayDeque<Node>();
	      Node cur = root, front = null, tail = null;

	   // In-order traversal via a stack (after Carrano)

	      while ( true )       // Infinite loop exited via break Carrano code is equivalent in behavior to a "while"
	      {
	         while ( cur != null )
	         {  stack.push ( cur );
	            cur = cur.left;
	         }
	         // What follows would be under Carrano's "else"
	         if ( stack.isEmpty() )
	            break;         // Exit the processing loop
	         else
	         {  cur = stack.pop ( );
	            if ( front == null )
	               front = tail = cur;
	            else
	               tail = tail.right = cur;
	            cur.left = null;
	            cur = cur.right;
	         }
	      }
	      root = front;
	   }


	   // FORM BALANCED TREE --- after Stout and Warren

	   {  //Pseudo-root used; real root to the right
	      Node pseudo = new Node(-1);
	      int  m, nBack = NodeCount - 1;

	      pseudo.right = root;
	      for ( m = nBack / 2; m > 0; m = nBack / 2 )
	      {
	         int  j = 0;
	         Node scanner = pseudo;

	         for ( j = 0; j < m; j++ )
	         {//leftward rotation
	            Node child = scanner.right;
	            scanner.right = child.right;
	            scanner = scanner.right;
	            child.right = scanner.left;
	            scanner.left = child;
	         }  // end for j . . .
	         nBack = nBack - m - 1;
	      }  // end for m . . .
	      root = pseudo.right;
	   }
	   return;
	}
}
