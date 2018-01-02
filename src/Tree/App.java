package Tree;

public class App {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
//		System.out.println(tree.isEmpty());
		tree.add(27);
		tree.add(19);
		tree.add(38);
		tree.add(40);
		tree.add(23);
		tree.add(9);
		tree.add(30);
		tree.add(1);
		tree.add(35);
		// System.out.println(tree.size());
		// System.out.println(tree.isEmpty());
//		 System.out.println(tree.contain(21));
//		 System.out.println(tree.contain(27));
//		 System.out.println(tree.contain(20));
		// System.out.println("max:" + tree.max().data);
		// System.out.println("min:" + tree.min().data);
		tree.print();
//		tree.reverse();
//		System.out.println("After reverse:");
//		tree.print();
		tree.clear();
		
	}
}
