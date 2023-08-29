import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// https://kim6394.tistory.com/201 참고

public class Main {
    public static int X, Y;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static boolean[][] map;

    public static class Node{
        int x;
        int y;
        int cnt;
        int drill;

        public Node(int x, int y, int cnt, int drill) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.drill = drill;
        }

        public void print(){
            System.out.println(x + ", " + y + ", " + cnt + ", " + drill);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new boolean[Y][X];

        for (int y = 0; y < Y; y++) {
            String line = br.readLine();
            for (int x = 0; x < X; x++) {
                if(line.charAt(x) == '1')
                    map[y][x] = true;
                else
                    map[y][x] = false;
            }
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        int mx, my;
        Node now, next;
        Deque<Node> q = new ArrayDeque<>();
        int[][] isVisited = new int[Y][X];

        q.add(new Node(0, 0, 1, 0));
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                isVisited[y][x] = Integer.MAX_VALUE;
            }
        }

        while (!q.isEmpty()) {
            now = q.poll();

            if (now.x == (X - 1) && now.y == (Y - 1)) {
                return now.cnt;
            }

            for (int i = 0; i < 4; i++) {
                mx = now.x + dx[i];
                my = now.y + dy[i];
                if (isRange(mx, my)) {
                    if (isVisited[my][mx] > now.drill) {
                        if (map[my][mx]) {
                            if(now.drill == 0){
                                isVisited[my][mx] = now.drill + 1;
                                q.add(new Node(mx, my, now.cnt + 1, now.drill + 1));
                            }
                        }
                        else{
                            isVisited[my][mx] = now.drill;
                            q.add(new Node(mx, my, now.cnt + 1, now.drill));
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isRange(int x, int y) {
        return (x >= 0 && x < X && y >= 0 && y < Y);
    }
}