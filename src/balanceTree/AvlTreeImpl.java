package balanceTree;

public class AvlTreeImpl implements AvlTree {

	private Node root;

	public AvlTreeImpl() {
		root = null;
	}

	@Override
	public void add(int e) {
		root = add(root, e);
	}

	private Node add(Node node, int e) {
		if (node == null) {
			return new Node(e);
		}
		if (e < node.data) {
			node.left = add(node.left, e);
		} else {
			node.right = add(node.right, e);
		}
		return balance(node);
	}

	private Node balance(Node node) {
		if (node == null)
			return node;
		if (height(node.left) - height(node.right) > 1) {
			if (height(node.left.left) >= height(node.left.right))
				node = rotateLeft(node);
			else
				node = doubleLeft(node);
		} else {
			if (height(node.right.right) >= height(node.right.left))
				node = rotateRight(node);
			else
				node = doubleRight(node);
		}
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return node;
	}

	private Node doubleRight(Node node) {
		node.right = rotateLeft(node.right);
		return rotateRight(node);
	}

	private Node rotateRight(Node node) {
		Node t = node.right;
		node.right = t.left;
		t.left = node;
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		t.height = Math.max(height(t.right), node.height) + 1;
		return t;
	}

	private Node doubleLeft(Node node) {
		node.left = rotateRight(node.left);
		return rotateLeft(node);
	}

	private Node rotateLeft(Node node) {
		Node t = node.left;
		node.left = t.right;
		t.right = node;
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		t.height = Math.max(height(t.left), node.height) + 1;
		return t;
	}

	private int height(Node node) {
		return node == null ? -1 : node.height;
	}

	@Override
	public Node remove(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node find() {
		// TODO Auto-generated method stub
		return null;
	}

	public void prevOder() {
		previous(root);
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

	@Override
	public void midOrder() {
		middle(root);
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

	@Override
	public void reverse() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void clear() {
		root = null;
	}

}
