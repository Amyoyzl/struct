package struct;

public class List implements AdtList {

	// 数据
	private String[] data;

	// 大小
	private int size;

	private static final int INIT_SIZE = 3;

	public List() {
		data = new String[INIT_SIZE];
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public void add(String s) {
		if (size == data.length)
			dilatation();
		data[size++] = s;
	}

	@Override
	public void add(int index, String s) {
		if (size == data.length)
			dilatation();
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		data[index] = s;
		size++;
	}

	public void dilatation() {
		// 扩容
		String[] newData = new String[size + INIT_SIZE];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	@Override
	public String get(int index) {
		if(index >= size) return null;
		return data[index];
	}

	@Override
	public String remove(int index) {
		String n = data[index];
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		size--;
		return n;
	}

	@Override
	public int size() {
		return size;
	}

	public void show() {
		for (int i = 0; i < size; i++) {
			System.out.print(data[i] + "  ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		List list = new List();
		System.out.println(list.size());
		list.add("Hello");
		list.add("World");
		list.add("Good");
		list.add("Morning");
		list.add(2, "text");
		list.show();
		
		list.remove(2);
		list.remove(3);
		list.show();
		
		list.clear();
		list.add("new");
		list.show();
		
		System.out.println(list.get(2));
		System.out.println(list.size());

	}

}
