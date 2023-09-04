import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static boolean[] isVisited;
    public static int[][] W;
    public static Stack<Integer> stack = new Stack<>();
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        N = Integer.parseInt(br.readLine());

        W = new int[N][N];
        isVisited = new boolean[N];

        for (int j = 0; j < N; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                W[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(ans);
    }

    public static void dfs(int num, int depth) {
        if (depth == N) {
            int sum = 0;

            for(int i = 0; i < N-1; i++){
                int s = stack.get(i);
                int e = stack.get(i + 1);
                if(W[s][e] == 0)
                    return;
                sum += W[s][e];
            }

            if(W[stack.peek()][stack.get(0)] == 0)
                return;
            sum += W[stack.peek()][stack.get(0)];

            ans = Math.min(ans, sum);
            return;
        }
        for (int next = 0; next < N; next++) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                stack.add(next);
                dfs(next, depth + 1);
                stack.pop();
                isVisited[next] = false;
            }
        }
    }
}