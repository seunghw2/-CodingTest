import java.io.*;
import java.util.*;

public class Main {
	public static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N;
        int[][] dp;
        int ans = 0;

		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][10];

		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;

		for(int n = 2; n <= N; n++){
			dp[n][0] = dp[n-1][1] % MOD;

			for(int x = 1; x <= 8; x++){
				dp[n][x] = dp[n-1][x-1] + dp[n-1][x+1];
				dp[n][x] %= MOD;
			}
			
			dp[n][9] = dp[n-1][8] % MOD;
		}

		for(int i = 0; i < 10; i++){
			ans += dp[N][i];
			ans %= MOD;
		}

		System.out.println(ans);
    }
}