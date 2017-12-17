package struct;

public class Queue {

	private String[] data = new String[9];

	private int head = 0;
	private int tail = 0;

	public void add(String e) {
		if (size() == data.length)
			throw new IndexOutOfBoundsException("队列已满");
		data[tail++] = e;
	}

	public String poll() {
		if (size() == 0)
			return null;
		return data[head++];
	}

	public String peek() {
		return data[head];
	}

	public int size() {
		return tail - head;
	}

	public void clear() {
		head = 0;
		tail = 0;
	}

	public boolean isEmpty() {
		return head == tail;
	}

	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.add("a");
		queue.add("b");
		queue.add("c");
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.size());
		queue.clear();
		System.out.println(queue.size());
	}

}
