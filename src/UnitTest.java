public class UnitTest {
	public static void main(String args[]) {

		IntervalTree itCase1 = new IntervalTree();
		
		itCase1.InsertOfInterval("A", 2, 5);
		itCase1.InsertOfInterval("B", 1, 3);
		itCase1.InsertOfInterval("C", 4, 8);
		itCase1.InsertOfInterval("D", 6, 9);
		itCase1.InsertOfInterval("E", 1, 20);
		itCase1.InsertOfInterval("F", 8, 16);
		
		System.out.print("The maximum number in this period is ");
		System.out.println(itCase1.QueryOfInterval(2, 5));
		
		IntervalTree itCase2 = new IntervalTree();
		itCase2.InsertOfInterval("A", 9, 18);
		itCase2.InsertOfInterval("B", 9, 18);
		itCase2.InsertOfInterval("C", 9, 19);
		itCase2.InsertOfInterval("D", 9, 17);
		itCase2.InsertOfInterval("E", 8, 20);
		itCase2.InsertOfInterval("F", 10, 18);
		
		System.out.print("The maximum number in this period is ");
		//System.out.println(itCase2.QueryOfInterval(9, 8));
		System.out.println(itCase2.QueryOfInterval(8, 9));
	}
}
