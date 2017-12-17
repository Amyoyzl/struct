package struct;

/**
 * 
 * @author Amy_oyzl
 *
 */
public class Node {

	/**
	 * 数据
	 */
	String data;
	
	/**
	 * 后继
	 */
	Node next;
	
	/**
	 * 前驱
	 */
	Node prev;
	
	public Node() {
	}
	
	public Node(String data, Node prev, Node next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	
}
