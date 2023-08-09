import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int idx;
		int dist;

		public Node(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
	}

	public static List<List<Node>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		int N, E;
		int a, b, c;
		int v1, v2;
		int ans;

		int[] oneDist;
		int[] v1Dist;
		int[] v2Dist;

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		oneDist = new int[N + 1];
		v1Dist = new int[N + 1];
		v2Dist = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		dijkstra(1, oneDist);
		dijkstra(v1, v1Dist);
		dijkstra(v2, v2Dist);

		if(oneDist[v1] == Integer.MAX_VALUE || oneDist[v2] == Integer.MAX_VALUE ||oneDist[N] == Integer.MAX_VALUE)
			System.out.println(-1);
		else {
			ans = Math.min(oneDist[v1] + v1Dist[v2] + v2Dist[N], oneDist[v2] + v2Dist[v1] + v1Dist[N]);
			System.out.println(ans);
		}
	}

	private static void dijkstra(int n, int dist[]) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
			return o1.dist - o2.dist;
		});
		Node cn;

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[n] = 0;
		pq.add(new Node(n, 0));

		while (!pq.isEmpty()) {
			cn = pq.poll();

			if (dist[cn.idx] < cn.dist)
				continue;

			for (Node nn : graph.get(cn.idx)) {
				if (dist[nn.idx] > cn.dist + nn.dist) {
					dist[nn.idx] = cn.dist + nn.dist;
					pq.add(new Node(nn.idx, dist[nn.idx]));
				}
			}
		}
	}
}