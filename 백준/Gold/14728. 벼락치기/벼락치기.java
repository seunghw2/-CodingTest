import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int Y, X;
        int cost, val;
        int[][] dp;

        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dp = new int[Y+1][X+1];

        for(int y = 1; y <= Y; y++){
            st = new StringTokenizer(br.readLine());
            cost = Integer.parseInt(st.nextToken());
            val = Integer.parseInt(st.nextToken());

            for(int x = 0; x <= X; x++){
                if(x >= cost)
                    dp[y][x] = Math.max(dp[y-1][x], dp[y-1][x-cost] + val);
                else
                    dp[y][x] = dp[y-1][x];
            }
        }

        System.out.print(dp[Y][X]);

//        for(int y = 1; y <= Y; y++){
//            for(int x = 0; x <= X; x++){
//                System.out.print(dp[y][x] + " ");
//            }
//            System.out.println();
//        }
    }
}