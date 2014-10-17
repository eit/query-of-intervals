
import java.util.ArrayList;
import java.util.List;

public class Node{
	
    public Node(int value) {
		this.value = value;
	}
	public int value;
    public Node parent;
    public Node right;
    public Node left;
    public List<String> collector = new ArrayList<String>();
}