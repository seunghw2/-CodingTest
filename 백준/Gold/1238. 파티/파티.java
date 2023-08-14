import java.io.*;
import java.util.*;

public class Main {
	public static class Node {
		int idx;
		int dist;

		public Node(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
	}

	public static List<Node>[] graph;
	public static int[][] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		int N, M, X;
		int a, b, c;
		int res = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		distance = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, c));
		}

		for (int i = 1; i <= N; i++) {
			dijkstra(i);
		}

		for (int i = 1; i <= N; i++) {
			res = Math.max(res, distance[i][X] + distance[X][i]);
		}

		System.out.println(res);
	}

	public static void dijkstra(int num) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.dist - o2.dist));

		Node pn, nn;

		Arrays.fill(distance[num], Integer.MAX_VALUE);
		distance[num][num] = 0;
		pq.add(new Node(num, 0));

		while (!pq.isEmpty()) {
			pn = pq.poll();

			if (distance[num][pn.idx] < pn.dist)
				continue;

			for (int i = 0; i < graph[pn.idx].size(); i++) {
				nn = graph[pn.idx].get(i);
				if (distance[num][nn.idx] > pn.dist + nn.dist) {
					distance[num][nn.idx] = pn.dist + nn.dist;
					pq.add(new Node(nn.idx, distance[num][nn.idx]));
				}
			}
		}
	}
}