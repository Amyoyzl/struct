package balanceTree;

public class App {

	public static void main(String[] args) {
		AvlTreeImpl tree = new AvlTreeImpl();
		tree.add(23);
		tree.add(16);
		tree.add(12);
		System.out.println("先序：");
		tree.prevOder();
		tree.midOrder();
		

	}

}
