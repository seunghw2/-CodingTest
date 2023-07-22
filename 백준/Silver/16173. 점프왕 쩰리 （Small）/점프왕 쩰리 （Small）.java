import java.io.*;
import java.util.*;

import static java.lang.System.exit;

class Main {
    public static boolean checkIn(int N, int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= N)
            return false;
        else
            return true;
    }

    public static void success(){
        System.out.println("HaruHaru");
        exit(0);
    }

    public static void dfs(int[][] map, int N, int x, int y){
//        System.out.println("x" + x + " y" + y);
        if(map[y][x] == -1){
            success();
        }
        else if(map[y][x] == 1){
            if(checkIn(N, x+1, y))
                dfs(map, N, x+1, y);
            if(checkIn(N, x, y+1))
                dfs(map, N, x, y+1);
        }
        else if(map[y][x] == 2){
            if(checkIn(N, x+2, y))
                dfs(map, N, x+2, y);
//            if(checkIn(N, x+1, y+1))
//                dfs(map, N, x+1, y+1);
            if(checkIn(N, x, y+2))
                dfs(map, N, x, y+2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(map, N, 0, 0);
        System.out.println("Hing");
    }
}