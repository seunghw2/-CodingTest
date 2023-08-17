import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		int N;
		int num;
		int size = 0;
		int idx;

		N = Integer.parseInt(br.readLine());
		dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			idx = bisearch(num, size);

			dp[idx] = num;

			if (idx == size) {
				size += 1;
			}
//			System.out.println(Arrays.toString(dp));
		}
		
		System.out.println(size);

	}

	public static int bisearch(int num, int size) {
		int lo = 0;
		int mid;
		int hi = size;

		while (lo < hi) {
			mid = (lo + hi) / 2;
			if (num > dp[mid])
				lo = mid + 1;
			else {
				hi = mid;
			}
		}
		return hi;
	}
}