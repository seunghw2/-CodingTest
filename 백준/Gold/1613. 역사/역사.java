import java.io.*;
import java.util.*;

public class Main {
    public static int N, K, S;
    public static boolean[][] history;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        history = new boolean[N][N];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            history[a][b] = true;
        }

        floyd();

        S = Integer.parseInt(br.readLine());

        for(int i = 0; i < S; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if(history[a][b])
                sb.append(-1).append("\n");
            else if(history[b][a])
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
        }

        System.out.println(sb);
    }

    public static void floyd(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(history[j][i] && history[i][k])
                        history[j][k] = true;
                }
            }
        }
    }
}