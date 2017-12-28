package Tree;

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

	private boolean contain(int e, Node parent) {
		if (parent.data == e) {
			return true;
		}
		if (e < parent.data) {
			return parent.left == null ? false : contain(e, parent.left);
		} else {
			return parent.right == null ? false : contain(e, parent.right);
		}
	}

	// 获得最大值
	public int max() {
		if(root==null)
			throw new NullPointerException();
		else {
			Node p = root;
			while(p.right != null) {
				p = p.right;
			}
			return p.data;
		}
	}
	
	// 获得最小值
	public int min() {
		if(root==null)
			throw new NullPointerException();
		else {
			Node p = root;
			while(p.left != null) {
				p = p.left;
			}
			return p.data;
		}
	}

}
