import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N, M, H;
        int[] dp;
        List<List<Integer>> lists = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        dp = new int[H + 1];

        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            lists.add(new ArrayList<>());
            String[] cmds = br.readLine().split(" ");
            for(int j = 0; j < cmds.length; j++)
                lists.get(i).add(Integer.parseInt(cmds[j]));
        }

        for (int v = 0; v < N; v++) {
            for (int w = H; w >= 0; w--) {
                for (int item : lists.get(v)) {
                    if (w - item >= 0) {
                        dp[w] += dp[w - item];
                        dp[w] %= 10007;
                    }
                }
            }
        }

        System.out.println(dp[H]);
    }
}