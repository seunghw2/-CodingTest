import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C, N;
        int cnt;
        int[] cost, val;
        int[] dp;

        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        cost = new int[N];
        val = new int[N];
        dp = new int[C + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            val[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                cnt = 1;
                for (int v = 1; v <= C; v++) {
                    dp[v] = cost[i] * cnt;
                    if (v % val[i] == 0)
                        cnt += 1;
                }
            }
            else {
                for (int v = 1; v <= C; v++) {
                    if (v - val[i] >= 0) {
                        dp[v] = Math.min(dp[v], dp[v - val[i]] + cost[i]);
                    }
                    else {
                        dp[v] = Math.min(dp[v], cost[i]);
                    }
                }
            }
        }
        System.out.println(dp[C]);
    }
}