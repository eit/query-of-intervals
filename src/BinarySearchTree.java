import java.util.ArrayDeque;
import java.util.Deque;

// 二元搜尋樹
public class BinarySearchTree {
	private Node root;
	private int NodeCount = 0;

	// 插入新的節點
	public void insert(int value) {
		Node node = new Node(value);
		NodeCount++;
		if (root == null) {
			root = node;
			return;
		}
		insertRecord(root, node);
	}

	private void insertRecord(Node latestRoot, Node node) {

		if (latestRoot.value > node.value) {

			if (latestRoot.left == null) {
				node.parent = latestRoot;
				latestRoot.left = node;
				return;
			} else {
				insertRecord(latestRoot.left, node);
			}
		} else {
			if (latestRoot.right == null) {
				node.parent = latestRoot;
				latestRoot.right = node;
				return;
			} else {
				insertRecord(latestRoot.right, node);
			}
		}
	}

	// 搜尋節點，找到的話回傳該節點
    public Node search(int value) {
        return searchRecord(root, value);
    }

    private Node searchRecord(Node latestRoot, int value) {
        if (latestRoot == null) return null;
        int cmp = value-latestRoot.value;
        if      (cmp < 0) return searchRecord(latestRoot.left, value);
        else if (cmp > 0) return searchRecord(latestRoot.right, value);
        else              return latestRoot;
    }
	/*
	public Node searchRecord(Node latestRoot, int value) {

		if (latestRoot.value == value) {
			return latestRoot;
		} else if (latestRoot.value > value) {
			if (latestRoot.left.value == value) {
				return latestRoot.left;
			} else {
				searchRecord(latestRoot.left, value);
			}
		} else {
			if (latestRoot.right.value == value) {
				return latestRoot.right;
			} else {
				searchRecord(latestRoot.right, value);
			}
		}
		return null;
	}
*/
    
	// 平衡歪斜樹
	public void balance() {
		if (NodeCount <= 1)
			return;

		// STRIP ITEMS FROM TREE AS LIST

		{// Taking advantage of Java's generic collections
			Deque<Node> stack = new ArrayDeque<Node>();
			Node cur = root, front = null, tail = null;

			// In-order traversal via a stack (after Carrano)

			while (true) // Infinite loop exited via break Carrano code is
							// equivalent in behavior to a "while"
			{
				while (cur != null) {
					stack.push(cur);
					cur = cur.left;
				}
				// What follows would be under Carrano's "else"
				if (stack.isEmpty())
					break; // Exit the processing loop
				else {
					cur = stack.pop();
					if (front == null)
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

		{ // Pseudo-root used; real root to the right
			Node pseudo = new Node(-1);
			int m, nBack = NodeCount - 1;

			pseudo.right = root;
			for (m = nBack / 2; m > 0; m = nBack / 2) {
				int j = 0;
				Node scanner = pseudo;

				for (j = 0; j < m; j++) {// leftward rotation
					Node child = scanner.right;
					scanner.right = child.right;
					scanner = scanner.right;
					child.right = scanner.left;
					scanner.left = child;
				} // end for j . . .
				nBack = nBack - m - 1;
			} // end for m . . .
			root = pseudo.right;
		}
		return;
	}
}
