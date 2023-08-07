import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		for (int i = 0; i < N + 1; i++)
			arr[i] = i;

		sb.append("<");

		int idx = 1;
		for (int i = 0; i < N - 1; i++) {
			int cnt = 0;

			while (true) {
				if (arr[idx] != -1) {
					cnt += 1;
					if (cnt == M) {
						cnt = 0;
						sb.append(idx).append(", ");
						arr[idx] = -1;
						break;
					}
				}
				idx = (idx == N) ? 1 : (idx + 1);
			}
		}

		for (int i = 1; i < N + 1; i++) {
			if (arr[i] != -1) {
				sb.append(i).append(">");
			}
		}

		System.out.println(sb);
	}
}