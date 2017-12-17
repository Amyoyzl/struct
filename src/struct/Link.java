package struct;

/**
 * 
 * @author Amy_oyzl
 *
 */
public class Link implements AdtList {

	private int size;

	// 头
	private Node head;

	// 尾
	private Node tail;

	public Link() {
		size = 0;
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		size = 0;
		head.next = tail;
		tail.prev = head;
	}

	@Override
	public void add(String data) {
		Node node = new Node(data, tail.prev, tail);
		tail.prev.next = node;
		tail.prev = node;

		size++;
	}

	@Override
	public void add(int index, String data) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("索引越界" + index);
		}
		Node old = getNode(index);
		Node node = new Node(data, old.prev, old);
		old.prev.next = node;
		old.prev = node;
		size++;
	}

	/**
	 * 获得特定的节点
	 * 
	 * @param index
	 * @return
	 */
	private Node getNode(int index) {
		if (index >= size)
			return null;
		Node node = head.next;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	@Override
	public String get(int index) {
		return getNode(index).data;
	}

	@Override
	public String remove(int index) {
		Node target = getNode(index);
		target.prev.next = target.next;
		target.next.prev = target.prev;
		return target.data;
	}

	@Override
	public int size() {
		return size;
	}

	public void show() {
		Node node = head.next;
		for (int i = 0; i < size - 1; i++) {
			System.out.print(node.data + "  ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Link link = new Link();
		link.add("hello");
		link.add("world");
		link.add("good");
		System.out.println(link.size());
		System.out.println(link.get(2));
		System.out.println(link.get(0));
		link.remove(1);
		link.add("test");
		link.add(2, "amy");
		System.out.println(link.get(0));
		System.out.println(link.get(1));
		System.out.println(link.get(2));
		System.out.println(link.get(3));
		
		System.out.println();
		link.show();
		
		System.out.println(link.isEmpty());
		link.clear();
		System.out.println(link.isEmpty());
		
	}

}
