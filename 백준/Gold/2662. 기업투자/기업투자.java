import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N, M;
        int[][] moneys;
        int[][] dp;
        int[][] comp;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[M][N + 1];
        moneys = new int[M][N + 1];
        comp = new int[M][N+1];

        for (int j = 1; j <= N; j++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for (int i = 0; i < M; i++) {
                moneys[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            for (int w = 1; w <= N; w++) {
                if(i == 0){
                    dp[i][w] = moneys[i][w];
                    comp[i][w] = w;
                }
                else {
                    dp[i][w] = dp[i-1][w];
                    for (int k = 1; k <= N; k++) {
                        if (w - k >= 0) {
                            if (dp[i][w] < moneys[i][k] + dp[i - 1][w - k]) {
                                dp[i][w] = moneys[i][k] + dp[i - 1][w - k];
                                comp[i][w] = k;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[M-1][N]);
//        for(int i = 0; i < M; i++){
//            System.out.println(Arrays.toString(dp[i]));
//            System.out.println(Arrays.toString(comp[i]));
//        }

        int a = N;
        int[] ans = new int[M];
        for(int i = M-1; i >= 0; i--){
            ans[i] = comp[i][a];
            a -= ans[i];
        }

        for(int x: ans)
            System.out.print(x + " ");
    }
}