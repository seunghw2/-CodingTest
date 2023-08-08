import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int idx;
		int dist;
		
		public Node(int idx, int dist) {
			super();
			this.idx = idx;
			this.dist = dist;
		}
	}

	public static int N;
	public static List<List<Node>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		int M;
		int a, b, c;
		int[] As, Bs, Cs, Mins;
		int in1, in2, in3;
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		As = new int[N+1];
		Bs = new int[N+1];
		Cs = new int[N+1];
		Mins = new int[N+1];

		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		M = Integer.parseInt(br.readLine());
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			in1 = Integer.parseInt(st.nextToken());
			in2 = Integer.parseInt(st.nextToken());
			in3 = Integer.parseInt(st.nextToken());
			graph.get(in1).add(new Node(in2, in3));
			graph.get(in2).add(new Node(in1, in3));
		}

		As = dijkstra(a);
		Bs = dijkstra(b);
		Cs = dijkstra(c);
		
		int idx = -1;
		int maxi = -1;
		int maxv = -1;
		int minTmp = -1;
		
		for(int i = 1; i <= N; i++) {
			minTmp = Math.min(Math.min(As[i], Bs[i]), Cs[i]);
			if(maxv < minTmp) {
				maxv = minTmp;
				maxi = i;
			}
		}
		
		System.out.println(maxi);
	}

	private static int[] dijkstra(int x) {
		int[] dist;
		Node cn;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> {
			return o1.dist - o2.dist;
		});
		
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[x] = 0;
		pq.add(new Node(x, 0));
		
		while(!pq.isEmpty()) {
			cn = pq.poll();
			
			if(cn.dist > dist[cn.idx])
				continue;
			
			for(Node nn :graph.get(cn.idx)) {
				if(dist[nn.idx] > cn.dist + nn.dist) {
					dist[nn.idx] = cn.dist + nn.dist;
					pq.add(new Node(nn.idx, dist[nn.idx]));
				}
			}
		}
		return dist;
	}
}