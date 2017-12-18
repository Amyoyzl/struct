package struct;

import java.util.Arrays;

public class Queue {

	private int[] data;

	private int head = 0;
	private int tail = 0;
	private int size = 0;

	public Queue(int n) {
		data = new int[n];
	}

	public void add(int e) {
		if (size == data.length) {
			System.out.println("队列已满");
			return;
		}
		data[tail++] = e;
		tail = tail % data.length;
		size++;
	}

	public int poll() {
		if (size == 0)
			System.out.println("队空！");
		else {
			size--;
			int d = data[head];
			data[head] = -1;
			head = (head + 1) % data.length;
			return d;
		}
		return -1;
	}

	public int peek() {
		return data[head];
	}

	public int size() {
		return size;
	}

	public void clear() {
		head = 0;
		tail = 0;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public void show() {
		System.out.println(Arrays.toString(data));
	}

	public static void main(String[] args) {
		int n = 5;
		Queue q = new Queue(n);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		q.show();
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		q.add(7);
		q.add(8);
		q.show();
	}
}
