package BinarySearchTree;

/**
 * 二叉树的节点
 * 
 * @author Amy_oyzl
 *
 */
public class Node {

	// 数据
	int data;
	// 左节点
	Node left;
	// 右节点
	Node right;

	public Node() {
	}

	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
