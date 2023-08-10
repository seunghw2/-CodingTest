import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		int N, M;
		int[] dp;
		int[] memories;
		int[] costs;
		int totMemory, targetMemory;
		int totCost;

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		memories = new int[N];
		costs = new int[N];

		st = new StringTokenizer(br.readLine());
		totMemory = 0;
		for (int i = 0; i < N; i++) {
			memories[i] = Integer.parseInt(st.nextToken());
			totMemory += memories[i];
		}
		targetMemory = totMemory - M;

		st = new StringTokenizer(br.readLine());
		totCost = 0;
		for (int i = 0; i < N; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
			totCost += costs[i];
		}

		dp = new int[targetMemory + 1];

		for (int app = 0; app < N; app++) {
			for (int memory = targetMemory; memory >= 0; memory--) {
				if (memories[app] > memory)
					continue;
				else {
					dp[memory] = Math.max(dp[memory], costs[app] + dp[memory - memories[app]]);
				}
			}
		}
		System.out.println(totCost - dp[targetMemory]);
	}
}