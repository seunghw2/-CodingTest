import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringBuilder sb = new StringBuilder();

		int W, M;
		int totWeight;
		int[] weights;
		boolean[][] dp;

		W = Integer.parseInt(br.readLine());
		weights = new int[W + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		totWeight = 0;
		for (int i = 1; i <= W; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
			totWeight += weights[i];
		}

		dp = new boolean[W + 1][totWeight + 1];

		M = Integer.parseInt(br.readLine());

		for (int w = 1; w <= W; w++) {
			for (int m = 0; m <= totWeight; m++) {

				// 1. 안 넣음
				if (dp[w - 1][m]) {
					dp[w][m] = true;
					continue;
				}
				// 2. 구슬 반대 쪽에 넣음
				// 2-1. 구슬의 무게가 현재 추의 무게보다 큼
				if (m > weights[w]) {
					if (dp[w - 1][m - weights[w]]) {
						dp[w][m] = true;
						continue;
					}
				}
				// 2-2. 구슬이 현재 무게와 같음
				else if (weights[w] == m) {
					dp[w][m] = true;
					continue;
				}
				// 2-3. 구슬의 무게가 현재 추의 무게보다 작음
				else {
					if (dp[w - 1][weights[w] - m]) {
						dp[w][m] = true;
						continue;
					}
				}

				// 3. 구슬과 같은 쪽에 넣음
				if (m + weights[w] <= totWeight) {
					if (dp[w - 1][m + weights[w]]) {
						dp[w][m] = true;
						continue;
					}
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int input = Integer.parseInt(st.nextToken());
			
			if(input > totWeight || !dp[W][input])
				sb.append("N ");
			else
				sb.append("Y ");
		}
		System.out.println(sb);
	}
}