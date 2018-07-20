package BinarySearchTree;

public class Test {

	public static void main(String[] args) {

		Tree tree = new Tree();
		// 添加节点
		tree.add(23);
		tree.add(17);
		tree.add(29);
		tree.add(25);
		tree.add(3);
		tree.add(47);
		tree.add(19);

		// 遍历节点
		System.out.println("先序遍历：");
		tree.previous();
		System.out.println("中序遍历：");
		tree.middle();
		System.out.println("后序遍历：");
		tree.last();
		
		// 翻转
		tree.reverse();
		// 翻转后中序遍历
		System.out.println("翻转后中序遍历：");
		tree.middle();
		
		tree.reverse();
		// 删除
		tree.remove(17);
		tree.middle();
		
		

	}
}
