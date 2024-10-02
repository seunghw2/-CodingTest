import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n, m;
		int a, b;
		Queue<int[]> q = new LinkedList<>();
		List<List<Integer>> graph = new ArrayList<>();
		boolean[] isVisited;

		n = Integer.parseInt(br.readLine());
		isVisited = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		q.add(new int[] {a, 0});
		isVisited[a] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			if(now[0] == b) {
				System.out.println(now[1]);
				return;
			}
			
			for(int next : graph.get(now[0])) {

				if(isVisited[next])
					continue;
				isVisited[next] = true;
				q.add(new int[] {next, now[1] + 1});
			}
		}
		System.out.println(-1);
	}
}