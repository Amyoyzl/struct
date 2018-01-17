package heap;

public class Test {

	public static void main(String[] args) {
		
		Heap heap = new Heap();
		
		heap.add(3);
		heap.add(7);
		heap.add(-1);
		heap.add(15);
		heap.add(21);
		heap.add(-8);
		heap.add(9);
		heap.add(60);
		heap.display();
//		System.out.println(heap.remove());
//		heap.display();
//		System.out.println(heap.remove());
//		heap.display();
//		System.out.println(heap.remove());
//		heap.display();
//		System.out.println(heap.remove());
//		heap.display();
//		System.out.println(heap.remove());
//		heap.display();
//		System.out.println(heap.remove());
//		heap.display();
//		System.out.println(heap.remove());
//		heap.display();
//		System.out.println(heap.remove());
//		heap.display();
//		System.out.println(heap.remove());
//		heap.display();
		heap.sort();
		heap.display();
	}

}
