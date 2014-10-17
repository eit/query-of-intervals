public class UnitTest {
	public static void main(String args[]) {

		IntervalTree it = new IntervalTree();
		
		it.InsertOfInterval("A", 2, 5);
		it.InsertOfInterval("B", 1, 3);
		it.InsertOfInterval("C", 4, 8);
		it.InsertOfInterval("D", 6, 9);
		it.InsertOfInterval("E", 1, 20);
		it.InsertOfInterval("F", 8, 16);
		
		System.out.println(it.QueryOfInterval(2, 5));
		
		//System.out.println(it.searchRecord(it.root, 3).value);
	}
}
