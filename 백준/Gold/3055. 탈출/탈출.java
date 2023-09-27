import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static int X, Y;
    public static boolean isSuccess;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static char[][] map;
    public static Point s, d;
    public static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int time = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new char[Y][X];

        for(int y = 0; y < Y; y++){
            String line = br.readLine();
            for(int x = 0; x < X; x++){
                map[y][x] = line.charAt(x);
                if(map[y][x] == 'S') {
                    s = new Point(x, y);
                    map[y][x] = '.';
                }
                else if(map[y][x] == 'D')
                    d = new Point(x, y);
            }
        }


//        for(int i = 0; i < 4; i++) {
//            int nx = s.x + dx[i];
//            int ny = s.y + dy[i];
//            if (isRange(nx, ny) && map[ny][nx] == '*') {
//                System.out.println("KAKTUS");
//                System.exit(0);
//            }
//        }
        q.add(new Point(s.x, s.y));

        while(!q.isEmpty()){
            if(!isSuccess){
                time += 1;
                spread();
                move();
            }
            else
                break;
        }
        if(isSuccess)
            System.out.println(time-1);
        else
            System.out.println("KAKTUS");
    }

    public static void move(){
        int cnt = q.size();

        for(int i = 0; i < cnt; i++){
            Point now = q.poll();

            if(now.x == d.x && now.y == d.y){
                isSuccess = true;
                return;
            }

            for(int j = 0; j < 4; j++){
                int mx = now.x + dx[j];
                int my = now.y + dy[j];

                if(isRange(mx, my)) {
                    if(map[my][mx] == '.' || map[my][mx] == 'D') {
                        map[my][mx] = '-';
                        q.add(new Point(mx, my));
                    }
                }
            }
        }
    }

    public static void spread(){
        for(int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if(map[y][x] == '*'){
                    for(int i = 0; i < 4; i++){
                        int mx = x + dx[i];
                        int my = y + dy[i];
                        if(isRange(mx,my)){
                            if(map[my][mx] == '.' || map[my][mx] == '-')
                                map[my][mx] = '-';
                        }
                    }
                }
            }
        }
        for(int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if(map[y][x] == '-')
                    map[y][x] = '*';
            }
        }
    }

    public static boolean isRange(int x, int y){
        return (x >= 0 && x < X && y >= 0 && y < Y);
    }

    public static void print(){
        for(int y = 0; y < Y; y++){
            for(int x = 0; x < X; x++){
                System.out.print(map[y][x]);
            }
            System.out.println();
        }
        System.out.println();
    }
}