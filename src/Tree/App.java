package Tree;

public class App {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.add(27);
		tree.add(20);
		tree.add(30);
		tree.add(32);
		tree.add(40);
		tree.print();
		tree.clear();

	}
}
