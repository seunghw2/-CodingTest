import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T, N;
        int cnt;
        int[] outs;
        boolean[] isVisited;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            cnt = 0;
            outs = new int[N + 1];
            isVisited = new boolean[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                outs[i] = Integer.parseInt(st.nextToken());
            }

            for (int start = 1; start <= N; start++) {
                if(isVisited[start])
                    continue;

                cnt += 1;

                isVisited[start] = true;
                int now = outs[start];

                while (now != start) {
                    isVisited[now] = true;
                    now = outs[now];
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}