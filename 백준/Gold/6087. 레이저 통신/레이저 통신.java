import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static int X, Y;
    public static Node C1;
    public static Node C2;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static char[][] map;

    public static class Node{
        int x;
        int y;
        int m;
        int d;

        public Node(int x, int y, int m, int d){
            this.x = x;
            this.y = y;
            this.m = m;
            this.d = d;
        }

        @Override
        public String toString(){
            return "[" + x + " / " + y + " / " + m + " / " + d + "]";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        map = new char[Y][X];
        C1 = new Node(-1, -1, -1, -1);
        C2 = new Node(-1, -1, -1, -1);

        for(int y = 0; y < Y; y++){
            String line = br.readLine();
            for(int x = 0; x < X; x++) {
                map[y][x] = line.charAt(x);
                if(map[y][x] == 'C'){
                    if(C1.x == -1)
                        C1 = new Node(x, y, -1, -1);
                    else
                        C2 = new Node(x, y, -1, -1);
                }
            }
        }
        System.out.println(getMirror());
    }

    public static int getMirror(){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.m, o2.m);
        });

        int[][] cost = new int[Y][X];
        for(int y = 0; y < Y; y++)
            Arrays.fill(cost[y], Integer.MAX_VALUE);

        int[][][] isVisited = new int[Y][X][4];
        for(int y = 0; y < Y; y++)
            for(int x = 0; x < X; x++)
                Arrays.fill(isVisited[y][x], Integer.MAX_VALUE);

        int minMir = Integer.MAX_VALUE;

        pq.add(C1);
        cost[C1.y][C1.x] = 0;

        isVisited[C1.y][C1.x][0] = 0;
        isVisited[C1.y][C1.x][1] = 0;
        isVisited[C1.y][C1.x][2] = 0;
        isVisited[C1.y][C1.x][3] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(now.m > cost[now.y][now.x])
                continue;

//            System.out.println();
//            for(int y = 0; y < Y; y++){
//                System.out.println(Arrays.toString(cost[y]));
//            }
//
//            System.out.print(now);

            if(now.m >= minMir)
                continue;

            if(now.x == C2.x && now.y == C2.y){
                minMir = now.m;
                continue;
            }

            for(int i = 0; i < 4; i ++){
                int mx = now.x + dx[i];
                int my = now.y + dy[i];
                if(isRange(mx, my) && map[my][mx] != '*'){
//                    System.out.print(" > i : " + i +" ---" + cost[my][mx] + "---" + now.m);
                    if(now.d == i) {
                        if(cost[my][mx] >= now.m && isVisited[my][mx][i] != now.m) {
//                            System.out.print(" > In ");
                            cost[my][mx] = now.m;
                            isVisited[my][mx][i] = now.m;
                            pq.add(new Node(mx, my, now.m, i));
                        }
                    }
                    else {
                        if(cost[my][mx] >= now.m + 1 && isVisited[my][mx][i] != now.m + 1){
//                            System.out.print(" > In ");
                            cost[my][mx] = now.m + 1;
                            isVisited[my][mx][i] = now.m + 1;
                            pq.add(new Node(mx, my, now.m + 1, i));
                        }
                    }
                }
            }
//            System.out.println();
        }
        return minMir;
    }

    public static boolean isRange(int x, int y){
        return (x >= 0 && x < X && y >= 0 && y < Y);
    }
}