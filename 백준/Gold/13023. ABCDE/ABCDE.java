import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static boolean suc;
	public static List<List<Integer>> graph = new ArrayList<>();
	public static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int n = 0; n < N; n++) {
			graph.add(new ArrayList<>());
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for(int m = 0; m < M; m++) {
			isVisited = new boolean[N];
			isVisited[m] = true;
			dfs(m, 0);
			if(suc) {
				System.out.println(1);
				return;
			}
		}
		
		System.out.println(0);
	}
	
	public static void dfs(int num, int depth) {
		if(depth == 4) {
			suc = true;
			return;
		}
		for(int next : graph.get(num)) {
			if(isVisited[next])
				continue;
			isVisited[next] = true;
			dfs(next, depth + 1);
			isVisited[next] = false;
		}
	}
}