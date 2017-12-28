package hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashSet;
import struct.HashTable;

public class Demo {

	public static void main(String[] args) {

		// HashTable<K,V>;
		// HashSet<E>;
		
		System.out.println(getHash(""));
		System.out.println(getHash("hard"));
		System.out.println(getHash("more"));
		System.out.println(getHash("more"));
	}

	private static String getHash(String msg) {
		// 摘要信息
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			// MessageDigest md = MessageDigest.getInstance("SHA-256");
			// MessageDigest md = MessageDigest.getInstance("SHA-1");
			// String msg = "hello world";
			// 16 个字节的输出
			byte[] output = md.digest(msg.getBytes());
			// System.out.println(output.length);
			// System.out.println(Arrays.toString(output));

			// 十六进制
			String hax = new BigInteger(1, output).toString(16);
			return hax;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
}
