import java.io.*;
import java.util.*;

public class Main {
	public static List<int[]>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		int n;
		int a, b, c;
		int ans = 0;

		n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			graph[a].add(new int[] { b, c });
		}


		for(int i = 1; i <= n; i++) {
			ans = Math.max(ans, dfs(i, 0, 0));
		}
		System.out.println(ans);
	}

	public static int dfs(int num, int length, int depth) {
		if (graph[num].size() == 0) {
			return length;
		}

		if (depth == 0) {
			int first = 0;
			int second = 0;
			int tmp;

			for (int i = 0; i < graph[num].size(); i++) {
				tmp = dfs(graph[num].get(i)[0], graph[num].get(i)[1], depth + 1);
				if (first < tmp) {
					second = first;
					first = tmp;
				} else if (second < tmp) {
					second = tmp;
				}
			}
			return 
					first + second;
		} 
		else {
			int ret = 0;
			for (int i = 0; i < graph[num].size(); i++) {
				ret = Math.max(ret, dfs(graph[num].get(i)[0], length + graph[num].get(i)[1], depth + 1));
			}
			return ret;
		}
	}
}