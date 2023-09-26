import java.io.*;
import java.util.*;

public class Main {
    public static int X, Y;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        paper = new int[Y][X];

        for(int y = 0; y < Y; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < X; x++){
                paper[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        markOut();

        while(!isClear()){
            markCheese();
            removeCheese();
            cnt += 1;
        }

        System.out.println(cnt);

    }

    public static boolean isClear(){
        for(int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if(paper[y][x] == 1)
                    return false;
            }
        }
        return true;
    }

    public static void removeCheese(){
        for(int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if(paper[y][x] == -2) {
                    paper[y][x] = -1;
                    markOutDfs(x, y);
                }
            }
        }
    }

    public static void markCheese(){
        for(int y = 0; y < Y; y++){
            for(int x = 0; x < X; x++) {
                if(paper[y][x] == 1 && shouldRemove(x, y)){
                    paper[y][x] = -2;
                }
            }
        }
    }

    public static boolean shouldRemove(int x, int y){
        int cnt = 0;

        for(int i = 0; i < 4; i++){
            int mx = x + dx[i];
            int my = y + dy[i];
            if(isRange(mx, my) && (paper[my][mx] == -1))
                cnt += 1;
        }

        if(cnt >= 2)
            return true;
        else
            return false;
    }

    public static void markOut(){
        for(int x = 0; x < X; x++){
            if(paper[0][x] == 0)
                markOutDfs(x, 0);
            if(paper[Y-1][x] == 0)
                markOutDfs(x, Y-1);
        }
        for(int y = 0; y < Y-1; y++){
            if(paper[y][0] == 0)
                markOutDfs(0, y);
            if(paper[y][X-1] == 0)
                markOutDfs(X-1, y);
        }
    }

    public static void markOutDfs(int x, int y){
        for(int i = 0; i < 4; i++){
            int mx = x + dx[i];
            int my = y + dy[i];

            if(isRange(mx, my)) {
                if(paper[my][mx] == 0) {
                    paper[my][mx] = -1;
                    markOutDfs(mx, my);
                }
            }
        }
    }

    public static boolean isRange(int x, int y){
        return (x >= 0 && x < X && y >= 0 && y < Y);
    }

    public static void print(){
        for(int y = 0; y < Y; y++){
            for(int x = 0; x < X; x++){
                if(paper[y][x] == -1)
                    System.out.print("_\t");
                else
                    System.out.print(paper[y][x]+"\t");

            }
            System.out.println();
        }
        System.out.println();
    }
}