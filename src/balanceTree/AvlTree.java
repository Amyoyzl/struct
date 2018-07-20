package balanceTree;

/**
 * 平衡二分搜索树
 * 
 * @author Amy_oyzl
 *
 */
public interface AvlTree {

	void add(int n);
	
	Node remove(int n);
	
	Node find();
	
	void midOrder();
	
	void reverse();
	
	boolean isEmpty();
	
	void clear();
	
	
}
