package struct;

public class Stack {	

	private String[] data = new String[9];

	private int top = -1;

	public void push(String s) {
		if (top == data.length - 1)
			throw new StackOverflowError();
		data[++top] = s;
	}

	public String pop() {
		if (top == -1)
			return null;
		String s = data[top--];
		return s;
	}

	public String peek() {
		if (top == -1)
			return null;
		return data[top];
	}

	public int size() {
		return top + 1;
	}

	public void clear() {
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void show() {
		for (int i = 0; i <= top; i++) {
			System.out.print(data[i] + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Stack stack = new Stack();
		stack.push("hello");
		stack.push("world");
		stack.push("good");
		stack.show();
		System.out.println(stack.size());
		stack.pop();
		stack.push("high");
		stack.show();
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());
		stack.clear();
		System.out.println(stack.isEmpty());

	}

}
