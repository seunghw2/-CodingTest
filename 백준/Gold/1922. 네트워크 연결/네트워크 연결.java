import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Node{
		int a;
		int b;
		int w;

		public Node(int a, int b, int w) {
			super();
			this.a = a;
			this.b = b;
			this.w = w;
		}
	}
	
	public static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		int N, M;
		int a, b, c;
		int tot = 0;
		
		Node pollNode, nextNode;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (Integer.compare(o1.w,  o2.w))); 
		
		parents = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(a, b, c));
		}
		
		while(!pq.isEmpty()) {
			pollNode = pq.poll();
			
			if(unionParent(pollNode.a, pollNode.b)) {
				tot += pollNode.w;
			}
		}
		
		System.out.println(tot);
	}
	
	public static int getParent(int num) {
		if(num == parents[num])
			return num;
		else
			return parents[num] = getParent(parents[num]);
	}
	
	public static boolean unionParent(int n1, int n2) {
		int p1 = getParent(n1);
		int p2 = getParent(n2);
		
		if(p1 == p2)
			return false;
		else {
			parents[p2] = p1;
			return true;
		}
	}
}