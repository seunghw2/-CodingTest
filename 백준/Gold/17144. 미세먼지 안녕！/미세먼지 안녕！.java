import java.io.*;
import java.util.*;

public class Main {
    public static int X, Y, T;
    public static int ax, ay1, ay2;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] dust;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        dust = new int[Y][X];

        for(int y = 0; y < Y; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < X; x++){
                dust[y][x] = Integer.parseInt(st.nextToken());
                if(dust[y][x] == -1){
                    ax = x;
                    if(ay1 == 0){
                        ay1 = y;
                    }
                    else{
                        ay2 = y;
                    }
                }
            }
        }

        for(int i = 0; i < T; i++){
            spread();
            rotate();
        }
        System.out.println(count());
    }

    public static void spread(){
        int[][] change = new int[Y][X];
        int val;

        for(int y = 0; y < Y; y++){
            for(int x = 0; x < X; x++){
                val = (int) (dust[y][x] / 5);

                for(int i = 0; i < 4; i++){
                    int mx = x + dx[i];
                    int my = y + dy[i];
                    if(isRange(mx, my) && dust[my][mx] != -1){
                        change[y][x] -= val;
                        change[my][mx] += val;
                    }
                }
            }
        }

        for(int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                dust[y][x] += change[y][x];
            }
        }
    }

    public static void rotate(){
        for(int y = ay1; y > 0; y--){
            dust[y][0] = dust[y-1][0];
        }
        for(int x = 0; x < X-1; x++){
            dust[0][x] = dust[0][x+1];
        }
        for(int y = 0; y < ay1; y++){
            dust[y][X-1] = dust[y+1][X-1];
        }
        for(int x = X-1; x > 1; x--){
            dust[ay1][x] = dust[ay1][x-1];
        }
        dust[ay1][0] = -1;
        dust[ay1][1] = 0;

        for(int y = ay2; y < Y-1; y++){
            dust[y][0] = dust[y+1][0];
        }
        for(int x = 0; x < X-1; x++){
            dust[Y-1][x] = dust[Y-1][x+1];
        }
        for(int y = Y-1; y >= ay2+1; y--){
            dust[y][X-1] = dust[y-1][X-1];
        }
        for(int x = X-1; x > 1; x--){
            dust[ay2][x] = dust[ay2][x-1];
        }
        dust[ay2][0] = -1;
        dust[ay2][1] = 0;
    }

    public static int count(){
        int cnt = 0;

        for(int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if(dust[y][x] != -1)
                    cnt += dust[y][x];
            }
        }

        return cnt;
    }

    public static boolean isRange(int x, int y){
        return (x >= 0 && x < X && y >= 0 && y < Y);
    }

    public static void print(){
        for(int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                System.out.print(dust[y][x] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}