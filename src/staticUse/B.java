package staticUse;

public class B extends A {
	public B() {
		System.out.println("I'm B!");
	}
	static {
		System.out.println("B static");
	}
}
