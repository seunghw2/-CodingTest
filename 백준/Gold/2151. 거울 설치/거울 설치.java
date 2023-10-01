import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static char[][] map;
    public static Node S1, S2;
    public static int MAX = 1_000_000;
    public static int ans = MAX;

    public static class Node{
        int x;
        int y;
        int cnt;
        int dir;

        public Node(int x, int y, int cnt, int dir){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
        }

        @Override
        public String toString(){
            return "[" + x + " / " + y + " / " + cnt + " / " + dir + "]";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        S1 = new Node(-1, -1, -1, -1);

        for(int y = 0; y < N; y++){
            String line = br.readLine();
            for(int x = 0; x < N; x++) {
                map[y][x] = line.charAt(x);
                if(map[y][x] == '#'){
                    if(S1.x == -1){
                        S1 = new Node(x, y, 0, -1);
                    }
                    else
                        S2 = new Node(x, y, -1, -1);
                }
            }
        }

        for(int i = 0; i < 4; i++){
            S1.dir = i;
            getMirror();
        }
        System.out.println(ans);
    }

    public static void getMirror(){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->{
            return Integer.compare(o1.cnt, o2.cnt);
        });

        int[][][] cost = new int[N][N][4];
        for(int y = 0; y < N; y++)
            for(int x = 0; x < N; x++)
                Arrays.fill(cost[y][x], MAX);

        pq.add(S1);

        for(int i = 0; i < 4; i++)
            cost[S1.y][S1.x][i] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(cost[now.y][now.x][now.dir] < now.cnt)
                continue;

//            System.out.println(now);

            if(now.x == S2.x && now.y == S2.y){
                ans = Math.min(ans, now.cnt);
            }

            // 이동
            int mx = now.x + dx[now.dir];
            int my = now.y + dy[now.dir];

            if(isRange(mx, my) && map[my][mx] != '*'){
                if(cost[my][mx][now.dir] > now.cnt) {
                    cost[my][mx][now.dir] = now.cnt;
                    pq.add(new Node(mx, my, now.cnt, now.dir));
                }
            }

            if(map[now.y][now.x] == '!'){
                if(now.dir == 0 || now.dir == 2){
                    for(int i = 1; i < 4; i += 2){
                        mx = now.x + dx[i];
                        my = now.y + dy[i];
                        if(isRange(mx, my) && map[my][mx] != '*'){
                            if(cost[my][mx][i] > now.cnt + 1) {
                                cost[my][mx][i] = now.cnt + 1;
                                pq.add(new Node(mx, my, now.cnt + 1, i));
                            }
                        }
                    }
                }
                else{
                    for(int i = 0; i < 4; i += 2) {
                        mx = now.x + dx[i];
                        my = now.y + dy[i];
                        if(isRange(mx, my) && map[my][mx] != '*'){
                            if(cost[my][mx][i] > now.cnt + 1) {
                                cost[my][mx][i] = now.cnt + 1;
                                pq.add(new Node(mx, my, now.cnt + 1, i));
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean isRange(int x, int y){
        return (x >= 0 && x < N && y >= 0 && y < N);
    }
}