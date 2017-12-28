package Tree;

public class Node {

	// 数据
	int data;

	// 左子树
	Node left;

	// 右子树
	Node right;

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
