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
    			dp[j][i][0] = arr[j][i] + maxCalc(i, j);
    			dp[j][i][1] = arr[j][i] + minCalc(i, j);
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
    	
//    	for(int y = 0; y < N; y++) {
//    		for(int x = 0; x < N; x++) {
//    			System.out.print(dp[y][x][1] + " ");
//    		}
//    		System.out.println();
//    	}
	}

	private static int maxCalc(int x, int y) {
		int a, b, c;
		
		if(x == 0) {
			b = dp[y-1][x][0];
			c = dp[y-1][x+1][0];
			return Math.max(b, c);
		}
		else if(x == 2) {
			a = dp[y-1][x-1][0];
			b = dp[y-1][x][0];
			return Math.max(a, b);
		}
		else {
			a = dp[y-1][x-1][0];
			b = dp[y-1][x][0];
			c = dp[y-1][x+1][0];
			return Math.max(Math.max(a, b), c);
		}
	}

	private static int minCalc(int x, int y) {
		int a, b, c;
		
		if(x == 0) {
			b = dp[y-1][x][1];
			c = dp[y-1][x+1][1];
			return Math.min(b, c);
		}
		else if(x == 2) {
			a = dp[y-1][x-1][1];
			b = dp[y-1][x][1];
			return Math.min(a, b);
		}
		else {
			a = dp[y-1][x-1][1];
			b = dp[y-1][x][1];
			c = dp[y-1][x+1][1];
			return Math.min(Math.min(a, b), c);
		}
	}
}