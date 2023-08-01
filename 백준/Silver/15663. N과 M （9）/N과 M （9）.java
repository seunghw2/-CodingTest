import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();
	public static Stack<Integer> stack = new Stack<>();
	public static List<Integer> oriList = new ArrayList<>();
	public static boolean[] isVisited;
	public static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		List<String> ansList = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			oriList.add(Integer.parseInt(st.nextToken()));
		}
		oriList.sort(null);
		
		isVisited = new boolean[N+1];
		
		dfs(0);
		
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if (depth == M) {
			StringBuilder tmp = new StringBuilder();
			for (int item : stack) {
				tmp.append(item).append(" ");
			}
			tmp.append("\n");
			
			if(!set.contains(tmp.toString())) {
				set.add(tmp.toString());
				sb.append(tmp.toString());
			}
		}

		for (int i = 0; i < oriList.size(); i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				stack.add(oriList.get(i));
				dfs(depth + 1);
				isVisited[i] = false;
				stack.pop();
			}
		}
	}
}