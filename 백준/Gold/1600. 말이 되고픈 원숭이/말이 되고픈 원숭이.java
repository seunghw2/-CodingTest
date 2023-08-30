import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int x;
        int y;
        int moveCnt;
        int skillCnt;

        public Node(int x, int y, int moveCnt, int skillCnt) {
            this.x = x;
            this.y = y;
            this.moveCnt = moveCnt;
            this.skillCnt = skillCnt;
        }
    }

    public static int K, X, Y;

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] sx = {-2, -2, -1, -1, 1, 1, 2, 2};
    public static int[] sy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static int[][] move;
    public static int[][] skill;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        move = new int[Y][X];
        skill = new int[Y][X];

        for (int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < X; x++) {
                if(st.nextToken().equals("0"))
                    move[y][x] = Integer.MAX_VALUE;
                else
                    move[y][x] = -1;

                skill[y][x] = Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        Deque<Node> dq = new ArrayDeque<>();

        dq.add(new Node(0, 0, 0, 0));
        skill[0][0] = 0;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if (now.x == X - 1 && now.y == Y - 1) {
                return now.moveCnt;
            }

            for(int i = 0; i < 8; i++){
                int mx = now.x + sx[i];
                int my = now.y + sy[i];

                if (isRange(mx, my)) {
                    if(move[my][mx] != -1){
                        if (skill[my][mx] > now.skillCnt + 1 && now.skillCnt + 1 <= K) {
                            move[my][mx] = now.moveCnt + 1;
                            skill[my][mx] = now.skillCnt + 1;
                            dq.add(new Node(mx, my, now.moveCnt + 1, now.skillCnt + 1));
                        }
                    }
                }
            }

            for(int i = 0; i < 4; i++){
                int mx = now.x + dx[i];
                int my = now.y + dy[i];

                if (isRange(mx, my)) {
                    if(move[my][mx] != -1){
                        if (skill[my][mx] > now.skillCnt) {
                            move[my][mx] = now.moveCnt + 1;
                            skill[my][mx] = now.skillCnt;
                            dq.add(new Node(mx, my, now.moveCnt + 1, now.skillCnt));
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

    public static void print() {
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                System.out.print(move[y][x]+" ");
            }
            System.out.println();
        }
    }
}