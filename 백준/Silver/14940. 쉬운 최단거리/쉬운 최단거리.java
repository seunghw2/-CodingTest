import java.awt.*;
import java.io.*;
import java.util.*;

import static java.lang.System.exit;

class Main {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int starty = -1;
        int startx = -1;
        int movx= -1;
        int movy = -1;

        Queue<Point> queue = new LinkedList<Point>();

        int[][] arr = new int[n][m];
        int[][] res = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    starty = i;
                    startx = j;
                    res[starty][startx] = 0;
                    queue.add(new Point(startx, starty));
                    visited[starty][startx] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            Point newPoint = queue.poll();
            for(int i = 0; i < 4; i++){
//                System.out.println(queue);
                movx = newPoint.x + dx[i];
                movy = newPoint.y + dy[i];
                if(movx < 0 || movx >= m || movy < 0 || movy >= n){
                    continue;
                }
                if(arr[movy][movx] == 0){
                    res[movy][movx] = 0;
                    visited[movy][movx] = true;
                    continue;
                }
                if(visited[movy][movx] == true)
                    continue;

                res[movy][movx] = res[newPoint.y][newPoint.x] + 1;
                visited[movy][movx] = true;
                queue.add(new Point(movx, movy));
                }
            }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == false){
                    if(arr[i][j] == 0)
                        res[i][j] = 0;
                    else
                        res[i][j] = -1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m-1; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println(res[i][m-1]);
        }
    }
}