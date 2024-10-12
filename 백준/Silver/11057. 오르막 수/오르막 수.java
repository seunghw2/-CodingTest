import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][10];
		
		for(int j = 0; j < 10; j++)
			dp[1][j] = 1;
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k <= j; k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= 10007;
				}
//				System.out.println(i + ", " + j + " : " + dp[i][j]);
			}
		}
		
		int answer = 0;
		for(int j = 0; j < 10; j++) {
			answer += dp[N][j];
			answer %= 10007;
		}
		
		System.out.println(answer);
    }
}