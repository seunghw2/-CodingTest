import java.io.*;
import java.util.*;

class Main {
	public static int[][][] dp;
	public static int N;

	public static void main(String[] args) throws IOException {
    	int maxV, minV;
    	int[][] arr;
    	
//    	BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	N = Integer.parseInt(br.readLine());
    	arr = new int[N][3];
    	dp = new int[N][3][2];
    	
    	for(int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 3; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for(int i = 0; i < 3; i++) {
    		dp[0][i][0] = arr[0][i];
    		dp[0][i][1] = arr[0][i];
    	}
    	
    	for(int j = 1; j < N; j++) {
    		for(int i = 0; i < 3; i++) {
    			for(int k = 0; k < 2; k++) {
    				dp[j][i][k] = arr[j][i] + calc(i, j, k);
    			}
    		}
    	}
    	
    	maxV = Integer.MIN_VALUE;
    	minV = Integer.MAX_VALUE;
    	
    	for(int i = 0; i < 3; i++) {
    		if(dp[N-1][i][0] > maxV)
    			maxV = dp[N-1][i][0];
    		if(dp[N-1][i][1] < minV) {
    			minV = dp[N-1][i][1];
    		}
    	}
    	System.out.println(maxV + " " + minV);
	}

	private static int calc(int x, int y, int k) {
		int a, b, c;
		
		if(x == 0) {
			b = dp[y-1][x][k];
			c = dp[y-1][x+1][k];
			return (k == 0) ? Math.max(b, c) : Math.min(b, c);
		}
		else if(x == 1){
			a = dp[y-1][x-1][k];
			b = dp[y-1][x][k];
			c = dp[y-1][x+1][k];
			return (k == 0) ? Math.max(Math.max(a, b), c) : Math.min(Math.min(a, b), c);
		}
		else {
			a = dp[y-1][x-1][k];
			b = dp[y-1][x][k];
			return (k == 0) ? Math.max(a, b) : Math.min(a, b);
		}
	}
}