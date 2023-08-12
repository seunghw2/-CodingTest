import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T, N, M;
        int[] coins;
        int[] dp;

        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            coins = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());
            dp = new int[M + 1];
            dp[0] = 1;

            for (int i = 0; i < N; i++) {
                for (int val = coins[i]; val <= M; val++) {
                    dp[val] = dp[val] + dp[val-coins[i]];
                }
            }

            sb.append(dp[M]).append("\n");
        }
        System.out.println(sb);
    }
}