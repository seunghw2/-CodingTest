import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX = 10000000;
    public static int N;
    public static int[][] floyd;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int T, M, W;
        boolean isPossible;
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            isPossible = false;

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            floyd = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    floyd[i][j] = MAX;
                }
            }

            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());

                if(floyd[a][b] > c) {
                    floyd[a][b] = c;
                }
                if(floyd[b][a] > c) {
                    floyd[b][a] = c;
                }
            }

            for (int w = 0; w < W; w++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());

                if(floyd[a][b] > -c)
                    floyd[a][b] = -c;
            }
            sb.append(floyd());
        }
        System.out.println(sb);
    }

    private static String floyd() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (floyd[i][j] > floyd[i][k] + floyd[k][j]) {
                        floyd[i][j] = floyd[i][k] + floyd[k][j];
                        if (floyd[i][i] < 0) {
                            return "YES\n";
                        }
                    }
                }
            }
        }
        return "NO\n";
    }

    public static void print(int[][] arr) {
        for (int[] items : arr) {
            for (int item : items) {
                System.out.print(item+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}