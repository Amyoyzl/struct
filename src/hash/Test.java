package hash;

public class Test {

	public static void main(String[] args) {
		
		HashTable table = new HashTable();
		table.add("alice");
		table.add("anna");
		table.add("alin");
		table.add("bob");
		table.add("john");
		System.out.println(table.find("bob"));
		System.out.println(table.find("anna"));
		System.out.println(table.find("amy"));
		table.print();
		

	}

}
