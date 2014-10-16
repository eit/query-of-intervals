/**
 * @author eit
 * @version v1.0
 */
public class IntervalTree extends BinarySearchTree {
	private int min, max;

	public IntervalTree() {
		this.min = 0;
		this.max = 23;

		for (int i = min; i < max; i++) {
			super.insert(i);
		}
		balance();
	}

	public void search(int upper, int lower) {
		
	}
}