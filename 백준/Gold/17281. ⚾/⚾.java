import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int score;
    public static int out;
    public static int ans;
    public static int[] field;
    public static int[] fourth;
    public static int[][] results;
    public static boolean[] isVisited = new boolean[8];
    public static int[] permutation = new int[8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        N = Integer.parseInt(br.readLine());

        fourth = new int[N];
        results = new int[N][8];

        for(int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            fourth[n] = Integer.parseInt(st.nextToken());
            for(int i = 0; i < 8; i++) {
                results[n][i] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(ans);
    }

    public static void dfs(int num, int depth) {
        int idx;

        if(depth == 8) {
            idx = 0;
            score = 0;

            for(int n = 0; n < N; n++) {
                out = 0;
                field = new int[4];

                while (out < 3) {
                    if(idx < 3)
                        calcScore(results[n][permutation[idx]]);
                    else if(idx == 3)
                        calcScore(fourth[n]);
                    else
                        calcScore(results[n][permutation[idx-1]]);

                    idx = (idx + 1) % 9;
                }
            }
            ans = Math.max(ans, score);
            return;
        }
        for(int i = 0; i < 8; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                permutation[depth] = i;
                dfs(i, depth + 1);
                isVisited[i] = false;
            }
        }
    }

    private static void calcScore(int num) {
        if(num == 0) {
            out += 1;
        }
        else if(num == 1) {
            score += field[3];
            field[3] = field[2];
            field[2] = field[1];
            field[1] = 1;
        }
        else if(num == 2) {
            score += (field[2] + field[3]);
            field[3] = field[1];
            field[2] = 1;
            field[1] = 0;
        }
        else if(num == 3) {
            score += (field[1] + field[2] + field[3]);
            field[3] = 1;
            field[2] = 0;
            field[1] = 0;
        }
        else if(num == 4) {
            score += (1 + field[1] + field[2] + field[3]);
            field[3] = 0;
            field[2] = 0;
            field[1] = 0;
        }
        else {
            System.out.println("WRONG");
        }
    }
}