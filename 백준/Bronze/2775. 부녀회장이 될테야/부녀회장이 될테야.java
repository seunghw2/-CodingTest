import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int k, n;
        
        for(int t = 0; t < T; t++) {
        	k = Integer.parseInt(br.readLine());
        	n = Integer.parseInt(br.readLine());
        	
        	int[][] dp = new int[k+1][n+1];
        	
        	for(int i = 0; i < n+1; i++) {
        		dp[0][i] = i;
        	}
        	
        	for(int i = 0; i < k+1; i++) {
        		dp[i][0] = 0;
        	}
        	for(int j = 1; j < k+1; j++) {
        		for(int i = 1; i < n+1; i++) {
        			dp[j][i] = dp[j][i-1] + dp[j-1][i];
        		}
        	}
        	System.out.println(dp[k][n]);
        }
    }
}