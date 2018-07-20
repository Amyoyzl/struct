package Graph;

public class Kruskal {

	private Edge[] edges;
	private int edgeSize;

	public Kruskal(int edgeSize) {
		this.edgeSize = edgeSize;
		this.edges = new Edge[edgeSize];
	}

	class Edge {
		private int begin;
		private int end;
		private int weight;

		public Edge(int begin, int end, int weight) {
			super();
			this.begin = begin;
			this.end = end;
			this.weight = weight;
		}

		public int getBegin() {
			return begin;
		}

		public void setBegin(int begin) {
			this.begin = begin;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}
	}

	public void creatEdgeArray() {
		edges[0] = new Edge(4, 7, 7);
		edges[1] = new Edge(2, 8, 8);
		edges[2] = new Edge(0, 1, 10);
		edges[3] = new Edge(0, 5, 11);
		edges[4] = new Edge(1, 8, 12);
		edges[5] = new Edge(3, 7, 16);
		edges[6] = new Edge(1, 6, 16);
		edges[7] = new Edge(5, 6, 17);
		edges[8] = new Edge(1, 2, 18);
		edges[9] = new Edge(6, 7, 19);
		edges[10] = new Edge(3, 4, 20);
		edges[11] = new Edge(3, 8, 21);
		edges[12] = new Edge(2, 3, 22);
		edges[13] = new Edge(3, 6, 24);
		edges[14] = new Edge(4, 5, 26);
	}

	public void minKruskal() {
		int m, n, sum = 0;
		// 验证回环的数组
		int[] parent = new int[edgeSize];
		for (int i = 0; i < edgeSize; i++) {
			parent[i] = 0;
		}
		for (int i = 0; i < edgeSize; i++) {
			n = find(parent, edges[i].begin);
			m = find(parent, edges[i].end);
			if (n != m) {
				parent[n] = m;
				System.out.println("起始顶点：" + edges[i].begin + "--结束顶点：" + edges[i].end);
				sum += edges[i].weight;
			}
		}
		System.out.println("最小数权值：" + sum);
	}

	// 验证是否回环
	public int find(int[] parent, int f) {
		while (parent[f] > 0) {
			f = parent[f];
		}
		return f;
	}
	
	public static void main(String[] args) {
		Kruskal k = new Kruskal(15);
		k.creatEdgeArray();
		k.minKruskal();
	}

}
