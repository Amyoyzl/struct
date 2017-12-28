package Tree;

public class App {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		System.out.println(tree.isEmpty());
		tree.add(27);
		tree.add(21);
		tree.add(25);
		tree.add(35);
		tree.add(32);
		tree.add(26);
		System.out.println(tree.size());
		// System.out.println(tree.isEmpty());
		// System.out.println(tree.contain(21));
		// System.out.println(tree.contain(27));
		// System.out.println(tree.contain(20));
		System.out.println("max:" + tree.max());
		System.out.println("min:" + tree.min());
	}
}
