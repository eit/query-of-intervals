/**
 * @author Jayson LP Chen
 * @version v1.0
 */
public class IntervalTree extends BinarySearchTree {
	private int min, max;

	public IntervalTree() {
		this.min = 0;
		this.max = 23;

		for (int i = min; i <= max; i++) {
			super.insert(i);
		}
		balance();
	}

	public void InsertOfInterval(String name, int LowerBound, int UpperBound) {
		
		for(int i = LowerBound; i<= UpperBound; i++)
		{
			super.search(i).collector.add(name);
		}
	}
	
	public int QueryOfInterval(int LowerBound, int UpperBound) {
		int MaxCount=0;
		for(int i = LowerBound; i<= UpperBound; i++)
		{
			if(MaxCount < super.search(i).collector.size()){
				MaxCount = super.search(i).collector.size();
			}
		}
		return MaxCount;
	}
}