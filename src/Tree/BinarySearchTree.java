package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分搜索树
 * 
 * @author Amy_oyzl
 *
 */
public class BinarySearchTree {

	// 根
	private Node root = null;

	// 节点数
	private int size = 0;

	// 存放树的队列
	Queue<Node> queue = new LinkedList<>();

	public boolean isEmpty() {
		return root == null;
	}

	public void clear() {
		root = null;
		// size = 0;
	}

	public int size() {
		return size;
	}

	public void add(int e) {
		if (root == null) {
			root = new Node(e);
		} else {
			add(e, root);
		}
		size++;
	}

	private void add(int e, Node parent) {
		Node node = new Node(e);
		// 存在根节点
		if (e < parent.data) {
			// 左
			if (parent.left == null) {
				parent.left = node;
			} else {
				add(e, parent.left);
			}

		} else {
			// 右
			if (parent.right == null) {
				parent.right = node;
			} else {
				add(e, parent.right);
			}
		}
	}

	// 是否包含某个元素
	public boolean contain(int e) {
		return contain(e, root);
	}

	private boolean contain(int e, Node node) {
		if (node.data == e) {
			return true;
		}
		if (e < node.data) {
			return node.left == null ? false : contain(e, node.left);
		} else {
			return node.right == null ? false : contain(e, node.right);
		}
	}

	/**
	 * 获取最大值
	 * 
	 * @return 返回最大值，若树为空的时候返回null
	 */
	public Node max() {
		if (root == null)
			return null;
		Node node = root;
		while (node.right != null)
			node = node.right;
		return node;
	}

	/**
	 * 获取最小值
	 * 
	 * @return 返回最小值，若树为空的时候返回空
	 */
	public Node min() {
		if (root == null)
			return null;
		return min(root);
	}

	private Node min(Node node) {
		return node.left == null ? node : min(node.left);
	}

	public void print() {
		 System.out.println("先序遍历：");
		 previous(root);
		 System.out.println();
		System.out.println("中序遍历：");
		middle(root);
		System.out.println();
		 System.out.println("后序遍历：");
		 later(root);
		 System.out.println();
		 System.out.println("层序遍历：");
		 sequence();
		 System.out.println();
	}

	private void previous(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + "  ");
		// 遍历左子树
		previous(node.left);
		// 遍历右子树
		previous(node.right);
	}

	private void middle(Node node) {
		if (node == null)
			return;
		// 遍历左子树
		middle(node.left);
		System.out.print(node.data + "  ");
		// 遍历右子树
		middle(node.right);
	}

	private void later(Node node) {
		if (node == null)
			return;
		// 遍历左子树
		later(node.left);
		// 遍历右子树
		later(node.right);
		System.out.print(node.data + "  ");

	}

	private void sequence() {
		if (root == null)
			return;
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.peek();
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
			System.out.print(queue.poll().data + "  ");
		}
	}

	public void reverse() {
		reverse(root);
	}

	private void reverse(Node node) {
		if (node != null) {
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
			reverse(node.left);
			reverse(node.right);
		} else
			return;
	}

}
