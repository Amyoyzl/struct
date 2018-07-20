package Tree;

public class Node {

	// 数据
	public int data;

	// 左子树
	public Node left;

	// 右子树
	public Node right;

	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	public Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

}
