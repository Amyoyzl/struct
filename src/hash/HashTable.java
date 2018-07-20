package hash;

public class HashTable {
	
	private Node[] table = new Node[26];
	
	public HashTable() {
		for(int i = 0; i < 26; i++) {
			table[i] = new Node("");
		}
	}
	
	public void print() {
		for(int i = 0; i < 26; i++) {
			System.out.println(table[i].data);
		}
	}
	
	private int hash(String data) {
		return data.toLowerCase().charAt(0) - 'a';
	}
	
	public void add(String data) {
		int index = hash(data);
		Node node = new Node(data);
		Node n = table[index];
		if(n == null)
			n = node;
		else {
			while(n.next!=null) {
				n = n.next;
			}
			n.next = node;
		}
	}
	
	public boolean find(String data) {
		int index = hash(data);
		Node node = table[index];
		if(node == null)
			return false;
		while(node!=null) {
			if(node.data.equals(data))
				return true;
			node = node.next;
		}
		return false;
	}
	

}
