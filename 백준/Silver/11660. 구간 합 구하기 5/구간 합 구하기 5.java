import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int N, M;
		int[][] arr, sum;
		int x1, y1, x2, y2;

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		sum = new int[N + 1][N + 1];

		for (int j = 1; j < N + 1; j++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N + 1; i++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		for (int j = 1; j < N + 1; j++) {
			for (int i = 1; i < N + 1; i++) {
				sum[j][i] = arr[j][i] + sum[j][i - 1] + sum[j - 1][i] - sum[j - 1][i - 1];
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			y1 = Integer.parseInt(st.nextToken());
			x1 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());

			sb.append(sum[y2][x2] - sum[y1 - 1][x2] - sum[y2][x1 - 1] + sum[y1 - 1][x1 - 1]).append("\n");
		}
		System.out.println(sb);
	}
}