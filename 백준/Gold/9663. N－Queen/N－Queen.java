import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int ans = 0;
    public static int N;
    public static int[][] isVisited;
    public static int[] dx = {1, 0, -1, 1};
    public static int[] dy = {0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        isVisited = new int[N][N];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                color(x, y, 1);
                dfs(0, y+1, 1);
                color(x, y, -1);
            }
        }
        System.out.println(ans);
    }

    public static void dfs(int x, int y, int depth) {
    	if (depth == N) {
            ans += 1;
            return;
        }

    	if(y == N)
    		return;
    	
        for(int i = 0; i < N; i++) {
            if (isVisited[y][i] == 0) {
                color(i, y, 1);
                dfs(0, y+1, depth + 1);
                color(i, y, -1);
            }
        }
    }

    private static void print() {

        for(int[] items: isVisited){
            for(int item: items){
                System.out.print(item+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void color(int x, int y, int plusMinus) {
        int mx;
        int my;

        isVisited[y][x] += plusMinus;

        for(int i = 0; i < 4; i++){
            mx = x + dx[i];
            my = y + dy[i];

            while(mx >= 0 && mx < N && my >= 0 && my < N){
                isVisited[my][mx] += plusMinus;
                mx = mx + dx[i];
                my = my + dy[i];
            }
        }
        
//        System.out.println(x + ", " + y + ", " + plusMinus);
//        print();
//        System.out.println();
    }
}