import java.io.*;
import java.util.*;

class Main {
	public static boolean[] isVisited;
	public static Stack<Integer> stack = new Stack<>();
	public static StringBuilder sb = new StringBuilder();
	public static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[N+1];
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if(depth == M) {
			for(int item: stack)
				sb.append(item).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				stack.add(i);
				dfs(depth+1);
				isVisited[i] = false;
				stack.pop();
			}
		}
	}
}