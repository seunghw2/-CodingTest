import java.io.*;
import java.util.*;

import static java.lang.System.exit;

class Main {
    public static int cnt = 0;

    public static void dfs(Integer[] coins, int N, int idx, int money){
        if(idx == N-1){
            if(money % coins[N-1] == 0){
                cnt += 1;
            }
        }
        else{
            for(int i = 0; coins[idx] * i <= money; i++){
                dfs(coins, N, idx + 1, money - coins[idx] * i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            Integer[] coins = new Integer[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            Arrays.sort(coins, Comparator.reverseOrder());

            dfs(coins, N, 0, M);
            System.out.println(cnt);
            cnt = 0;
        }
    }
}