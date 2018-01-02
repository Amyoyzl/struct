package struct;

public class Tree {
	
	private TNode root;
	
	public void show() {
		System.out.println(root.data);
		root.show();
	}
	
	public static void main(String[] args) {
		
		Tree tree = new Tree();
		TNode grand = new TNode("grandfather");
		TNode father = new TNode("father");
		TNode me = new TNode("meself");
		TNode sister = new TNode("sister");
		TNode uncle = new TNode("uncle");
		TNode brother = new TNode("brother");
		TNode cousin = new TNode("cousin");
		uncle.left = brother;
		uncle.right = cousin;
		father.left = me;
		father.right = sister;
		grand.left = father;
		grand.right = uncle;
		tree.root = grand;
		tree.show();
		
	}

}
