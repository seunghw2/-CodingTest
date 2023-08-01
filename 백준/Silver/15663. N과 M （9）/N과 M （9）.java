import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();
	public static Stack<Integer> stack = new Stack<>();
	public static List<Integer> list = new ArrayList<>();
	public static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		List<String> ansList = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		isVisited = new boolean[N+1];
		
		list.sort(null);
		dfs(0);
		
		for(String item: ansList) {
			sb.append(item);
		}
		System.out.println(sb);
	}
	
	private static void dfs(int depth) {
		if(depth == M) {
			for(int item: stack) {
				sb.append(item).append(' ');
			}
			sb.append("\n");
		}
		
		int prev = 0;
		for(int i = 0; i < N; i++) {
			if(!isVisited[i]) {
				if(list.get(i) != prev) {
					prev = list.get(i);
					isVisited[i] = true;
					stack.add(list.get(i));
					dfs(depth+1);
					isVisited[i] = false;
					stack.pop();
				}
			}
		}
	}
}