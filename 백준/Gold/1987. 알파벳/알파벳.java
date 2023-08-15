import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static int R, C;
    public static int ans = 0;
    public static Set<Character> set = new HashSet<>();
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, -1, 1, 0};
    public static char[][] boards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        boards = new char[R][C];
        for(int j = 0; j < R; j++){
            String line = br.readLine();
            for(int i = 0; i < C; i++){
                boards[j][i] = line.charAt(i);
            }
        }

        set.add(boards[0][0]);
        dfs(0, 0, 1);
        System.out.println(ans);
    }

    public static void dfs(int x, int y, int depth) {
        int mx, my;

        if(ans < depth)
            ans = depth;

        for (int i = 0; i < 4; i++) {
            mx = x + dx[i];
            my = y + dy[i];
            if (isRange(mx, my)) {
                if (!set.contains(boards[my][mx])) {
                    set.add(boards[my][mx]);
                    dfs(mx, my, depth + 1);
                    set.remove(boards[my][mx]);
                }
            }
        }
    }

    public static boolean isRange(int x, int y) {
        return (x >= 0 && x < C && y >= 0 && y < R);
    }
}