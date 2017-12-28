package struct;

import java.util.Arrays;

/**
 * 散列表（键值对、字典、哈希表）
 * 
 * @author Amy_oyzl
 *
 */
public class HashTable {

	String[] keys;
	int[] values;

	public HashTable() {
		keys = new String[7];
		values = new int[7];
	}

	/**
	 * 放入散列表
	 * 
	 * @param key
	 *            键（字典）
	 * @param v
	 *            值
	 */
	public void put(String key, int v) {
		int index = hash(key);
		// 冲突检测，线性探测
		while (keys[index] != null) {
			index++;
			if (index == keys.length)
				index = 0;
		}
		keys[index] = key;
		values[index] = v;
	}

	/**
	 * 散列函數
	 * 
	 * @param key
	 * @return
	 */
	private int hash(String key) {
		int n = 0;
		for (char c : key.toCharArray()) {
			n += c;
		}
		return n % keys.length;
	}

	/**
	 * 由键获得值
	 * 
	 * @param key
	 * @return
	 */
	public int get(String key) {
		int index = hash(key);
		// 冲突检测，线性探测
		while (!keys[index].equals(key)) {
			index++;
			if (index == keys.length)
				index = 0;
		}
		return values[index];
	}

	public static void main(String[] args) {
		HashTable hashTable = new HashTable();
		hashTable.put("alice", 21);
		hashTable.put("bob", 25);
		hashTable.put("aoc", 22);
		hashTable.put("jack", 23);
		hashTable.put("nick", 26);
		System.out.println(Arrays.toString(hashTable.keys));
		System.out.println(Arrays.toString(hashTable.values));
		System.out.println("---------------------");
		System.out.println(hashTable.get("alice"));
		System.out.println(hashTable.get("bob"));
		System.out.println(hashTable.get("aoc"));
		System.out.println(hashTable.get("jack"));
		System.out.println(hashTable.get("nick"));
	}

}
