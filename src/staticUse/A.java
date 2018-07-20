package staticUse;

public class A {
	public A() {
		System.out.println("I'm A!");
	}
	static {
		System.out.println("A static");
	}
}
