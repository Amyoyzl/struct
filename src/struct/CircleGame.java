package struct;

public class CircleGame {

	public static void main(String[] args) {
		int[] n = new int[21];
		int k = 5;
		int c = 0;
		int len = n.length;
		for (int i = 0; i < n.length; i++)
			n[i] = i + 1;
		while (len != 1) {
			for (int i = 0; i < n.length; i++) {
				if (n[i] != 0) {
					c++;
					if (c == k) {
						c = 0;
						n[i] = 0;
						len--;
					}
				}
			}
		}
		for (int i = 0; i < n.length; i++)
			if (n[i] != 0) {
				System.out.println(n[i]);
				break;
			}
	}

}
