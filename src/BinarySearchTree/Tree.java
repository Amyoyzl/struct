package BinarySearchTree;

/**
 * 二分搜索树
 * 
 * @author Amy_oyzl
 *
 */
public class Tree {

	// 根结点
	Node root = null;

	/**
	 * 添加节点
	 * 
	 * @param data
	 *            结点数据
	 */
	public void add(int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			root = add(data, root);
		}
	}

	/**
	 * 添加节点
	 * 
	 * @param data
	 *            结点数据
	 * @param node
	 *            父结点
	 */
	private Node add(int data, Node node) {

/*		Node n = new Node(data);
		// 存在根节点
		if (data < node.data) {
			// 左
			if (node.left == null) {
				node.left = n;
			} else {
				add(data, node.left);
			}
		} else {
			// 右
			if (node.right == null) {
				node.right = n;
			} else {
				add(data, node.right);
			}
		}*/
		if(node == null) {
			node = new Node(data);
			return node;
		}
		if(data < node.data)
			node.left = add(data, node.left);
		else
			node.right = add(data,node.right);
		return node;
	}

	/**
	 * 根据数据删除结点,删除时保证二分搜索树的中序遍历序列是递增的。
	 * 
	 * @param data
	 */
	public void remove(int data) {
		if (root == null) {
			System.out.println("元素不存在！");
			return;
		}
		if (data == root.data)
			root = null;
		else
			remove(root, data);
	}

	private void remove(Node node, int data) {
		if (node != null) {
			if (data == node.data) { // 找到元素所在的节点
				if (node.left == null && node.right == null) // 该数据的左右节点为空
					node = null;
				else if (node.left != null && node.right == null) // 该数据的右节点为空
					node = node.left;
				else if (node.left == null && node.right != null) // 该数据的左节点为空
					node = node.right;
				else { // 该数据有左右节点
					Node temp = node.left;
					node = node.right;
					Node n = node.right;
					while (n.left != null) {
						n = n.left;
					}
					n.left = temp;
				}
				System.out.println("删除成功！");
			} else if (data < node.data) {
				// 遍历左节点
				remove(node.left, data);
			} else
				// 遍历右节点
				remove(node.right, data);

		} else
			System.out.println("元素不存在！");
	}

	/**
	 * 翻转
	 */
	public void reverse() {
		reverse(root);
	}

	private void reverse(Node node) {
		if (node != null) {
			// 交换左右节点
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
			// 递归交换左右结点
			reverse(node.left);
			reverse(node.right);
		} else
			return;
	}

	/**
	 * 先序遍历
	 */
	public void previous() {
		previous(root);
		System.out.println();
	}

	/**
	 * 先序遍历
	 * 
	 * @param node
	 */
	private void previous(Node node) {
		if (node == null)
			return;
		// 输出结点
		System.out.print(node.data + "  ");
		// 遍历左子树
		previous(node.left);
		// 遍历右子数
		previous(node.right);

	}

	/**
	 * 中序遍历
	 */
	public void middle() {
		middle(root);
		System.out.println();
	}

	/**
	 * 中序遍历
	 * 
	 * @param node
	 */
	private void middle(Node node) {
		if (node == null)
			return;
		// 遍历左子树
		middle(node.left);
		// 输出结点
		System.out.print(node.data + "  ");
		// 遍历右子数
		middle(node.right);
	}

	/**
	 * 后序遍历
	 */
	public void last() {
		last(root);
		System.out.println();
	}

	/**
	 * 后序遍历
	 * 
	 * @param node
	 */
	private void last(Node node) {
		if (node == null)
			return;
		// 遍历左子树
		last(node.left);
		// 遍历右子数
		last(node.right);
		// 输出结点
		System.out.print(node.data + "  ");
	}

}
