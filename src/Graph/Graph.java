package Graph;

import java.util.LinkedList;

public class Graph {

	private int vertexSize; // 顶点数量
	private int[] vertexs; // 顶点
	private int[][] matrix; // 图的存储矩阵
	private final static int MAX_WEIGHT = Integer.MAX_VALUE;
	private boolean[] isVisited;

	public Graph(int vertexSize) {
		this.vertexSize = vertexSize;
		vertexs = new int[vertexSize];
		matrix = new int[vertexSize][];
		for (int i = 0; i < vertexSize; i++) {
			vertexs[i] = i;
		}
		isVisited = new boolean[vertexSize];
	}

	public int[] getVertexs() {
		return vertexs;
	}

	public void setVertexs(int[] vertexs) {
		this.vertexs = vertexs;
	}

	/**
	 * 获取某个顶点的出度
	 * 
	 * @param index
	 * @return 出度
	 */
	public int getOutDegree(int index) {
		int degree = 0;
		for (int i = 0; i < matrix[index].length; i++) {
			int weight = matrix[index][i];
			if (weight != 0 && weight != MAX_WEIGHT) {
				degree++;
			}
		}
		return degree;
	}

	/**
	 * 获取某个顶点的入度
	 * 
	 * @param index
	 * @return 入度
	 */
	public int getInDegree(int index) {
		int degree = 0;
		for (int i = 0; i < vertexSize; i++) {
			int weight = matrix[i][index];
			if (weight != 0 && weight != MAX_WEIGHT) {
				degree++;
			}
		}
		return degree;
	}

	/**
	 * 获取两个顶点之间的权值
	 * 
	 * @param v1
	 * @param v2
	 * @return 权值
	 */
	public int getWeight(int v1, int v2) {
		int weight = matrix[v1][v2];
		return weight == 0 ? 0 : (weight == MAX_WEIGHT ? -1 : weight);
	}

	/**
	 * 获取某个顶点的第一个邻接点
	 * 
	 * @param v
	 * @return 邻接点
	 */
	public int getFirstNeighbor(int v) {
		for (int i = 0; i < vertexSize; i++) {
			if (matrix[v][i] > 0 && matrix[v][i] < MAX_WEIGHT) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 获取下一个邻接点
	 * 
	 * @param v
	 * @param index
	 * @return 邻接点
	 */
	public int getNextNeighbor(int v, int index) {
		for (int i = index + 1; i < vertexSize; i++) {
			if (matrix[v][i] > 0 && matrix[v][i] < MAX_WEIGHT) {
				return i;
			}
		}
		return -1;
	}

	private void depthFirstSearch(int i) {
		isVisited[i] = true;
		System.out.println("访问到了" + i + "顶点。");
		int w = getFirstNeighbor(i);
		while (w != -1) {
			if (!isVisited[w]) {
				// 需要遍历该顶点
				depthFirstSearch(w);
			}
			w = getNextNeighbor(i, w); // 第一个相对于w的下一个结点
		}
	}

	/**
	 * 可遍历无向连通图
	 */
	public void depthFirstSearch() {
		isVisited = new boolean[vertexSize];
		for (int i = 0; i < vertexSize; i++) {
			if (!isVisited[i]) {
				depthFirstSearch(i);
			}
		}
		isVisited = new boolean[vertexSize];
	}

	/**
	 * 广度遍历
	 */
	public void broadFirstSearch() {
		isVisited = new boolean[vertexSize];
		for (int i = 0; i < vertexSize; i++) {
			if (!isVisited[i]) {
				broadFirstSearch(i);
			}
		}
	}

	/**
	 * 广度遍历
	 * 
	 * @param i
	 */
	private void broadFirstSearch(int i) {
		int u, w;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		System.out.println("访问到了" + i + "顶点。");
		isVisited[i] = true;
		queue.add(i); // 把v0加入队列
		while (!queue.isEmpty()) {
			u = (Integer) (queue.removeFirst()).intValue();
			w = getFirstNeighbor(u);
			while (w != -1) {
				if (!isVisited[w]) {
					System.out.println("访问到了" + w + "顶点。");
					isVisited[w] = true;
					queue.add(w);
				}
				w = getNextNeighbor(u, w);
			}
		}
	}

	/**
	 * 普里姆算法求最小生成树
	 */
	public void prim() {
		// 保存相连最小代价，0表示已经确定权值
		int[] lowcost = new int[vertexSize];
		// 放权值
		int[] adjvex = new int[vertexSize];
		int min, minId, sum = 0;
		for (int i = 1; i < vertexSize; i++) {
			lowcost[i] = matrix[0][i];
		}
		for (int i = 1; i < vertexSize; i++) {
			min = MAX_WEIGHT;
			minId = 0;
			for (int j = 1; j < vertexSize; j++) {
				if (lowcost[j] < min && lowcost[j] > 0) {
					min = lowcost[j];
					minId = j;
				}
			}
			System.out.println("顶点" + adjvex[minId] + "权值为" + min);
			sum += min;
			lowcost[minId] = 0;
			adjvex[minId] = min;
			for (int j = 1; j < vertexSize; j++) {
				if (lowcost[j] != 0 && matrix[minId][j] < lowcost[j]) {
					lowcost[j] = matrix[minId][j];
				}
			}
		}
		System.out.println("最小生成树权值和：" + sum);
	}

	public static void main(String[] args) {
		Graph graph = new Graph(9);
		graph.matrix[1] = new int[] { 10, 0, 18, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, MAX_WEIGHT, 12 };
		graph.matrix[0] = new int[] { 0, 10, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 11, MAX_WEIGHT, MAX_WEIGHT,
				MAX_WEIGHT };
		graph.matrix[2] = new int[] { MAX_WEIGHT, MAX_WEIGHT, 0, 22, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT,
				8 };
		graph.matrix[3] = new int[] { MAX_WEIGHT, MAX_WEIGHT, 22, 0, 20, MAX_WEIGHT, MAX_WEIGHT, 16, 21 };
		graph.matrix[4] = new int[] { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 20, 0, 26, MAX_WEIGHT, 7, MAX_WEIGHT };
		graph.matrix[5] = new int[] { 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 26, 0, 17, MAX_WEIGHT, MAX_WEIGHT };
		graph.matrix[6] = new int[] { MAX_WEIGHT, 16, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 17, 0, 19, MAX_WEIGHT };
		graph.matrix[7] = new int[] { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, 7, MAX_WEIGHT, 19, 0, MAX_WEIGHT };
		graph.matrix[8] = new int[] { MAX_WEIGHT, 12, 8, 21, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0 };
		// System.out.println(graph.getOutDegree(4));
		// System.out.println(graph.getInDegree(3));
		// System.out.println(graph.getWeight(0, 5));
		// System.out.println(graph.getFirstNeighbor(6));
		// System.out.println(graph.getNextNeighbor(6, 3));
		// graph.depthFirstSearch();
		// graph.broadFirstSearch();
//		graph.prim();

	}

}
