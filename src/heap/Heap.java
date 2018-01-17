package heap;

import java.util.Arrays;

public class Heap implements IHeap {

	// 物理结构
	// 完全二叉树
	int[] data = new int[17];

	int current = 1;

	@Override
	public void add(int e) {
		if (current == 1)
			data[current] = e;
		else {
			int next = current;
			while ((next / 2) != 0 && e > data[next / 2]) {
				data[next] = data[next / 2];
				next = next / 2;
			}
			data[next] = e;
		}
		current++;
	}

	@Override
	public int remove() {
		if (current == 1) {
			System.out.println("NULL");
			return Integer.MIN_VALUE;
		}
		int m = data[1];
		int temp = data[--current];
		int hole = 1;
		int child;
		while (hole * 2 <= current) {
			child = hole * 2;
			if (child != current && data[child] < data[child + 1]) {
				child++;
			}
			if (data[child] > temp) 
				data[hole] = data[child];	
			else
				break;
			hole = child;
		}
		data[hole] = temp;
		data[current] = 0;
		return m;
	}

	public void sort() {
		int len = current;
		for (int i = 1; i < len; i++) {
			int m = data[1];
			int temp = data[--current];
			int hole = 1;
			int child;
			while (hole * 2 <= current) {
				child = hole * 2;
				if (child != current && data[child] < data[child + 1]) {
					child++;
				}
				if (data[child] > temp) 
					data[hole] = data[child];	
				else
					break;
				hole = child;
			}
			data[hole] = temp;
			data[current] = m;
		}
	}

	public void display() {
		System.out.println(Arrays.toString(data));
	}

}
