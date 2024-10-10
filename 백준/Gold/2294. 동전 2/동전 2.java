import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[n];
		for(int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[k+1];
		
		for(int i = 1; i <= k; i++) {
			int min = 100000;
			
			for(int coin: coins) {
				if(i - coin < 0)
					continue;
				
				min = Math.min(min, dp[i-coin] + 1);
			}
			
			dp[i] = min;
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[k] >= 100000 ? -1 : dp[k]);
    }
}