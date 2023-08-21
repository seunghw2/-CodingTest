import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringBuilder sb = new StringBuilder();

		int N, M;
		int a, b;
		int item, next;
		int[] edgeCnt;
		Queue<Integer> q = new LinkedList<Integer>();
		List<List<Integer>> graph = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edgeCnt = new int[N+1];
		edgeCnt[0] = -1;
		for(int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			edgeCnt[b] += 1;
		}
		
		for(int i = 1; i <= N; i++) {
			if(edgeCnt[i] == 0)
				q.add(i);
		}
		
		while(!q.isEmpty()) {
			item = q.poll();
			
			sb.append(item).append(" ");
			
			for(int i = 0; i < graph.get(item).size(); i++) {
				next = graph.get(item).get(i);
				edgeCnt[next] -= 1;
				if(edgeCnt[next] == 0)
					q.add(next);
			}
		}
		
		System.out.println(sb);
	}
}