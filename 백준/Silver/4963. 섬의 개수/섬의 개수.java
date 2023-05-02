import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int w;
        int h;
        int map[][];
        int item[];
        int movx[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        int movy[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int xx;
        int yy;
        int answer;
        Queue<int[]> queue = new LinkedList<>();

        while(true){
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0){
                break;
            }
            map = new int[h][w];
            item = new int[2];
            xx = -1;
            yy = -1;
            answer = 0;

            queue = new LinkedList<>();

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int y = 0; y < h; y++){
                for(int x = 0; x < w; x++){
                    if(map[y][x] == 1){
                        // BFS
                        queue.add(new int[]{x, y});
                        map[y][x] = 0;
                        answer += 1;
                        while (!queue.isEmpty()){
                            item = queue.poll();
                            for(int i = 0; i < 8; i++){
                                xx = item[0] + movx[i];
                                yy = item[1] + movy[i];
                                if(xx >= 0 && xx < w && yy >= 0 && yy < h){
                                    if(map[yy][xx] == 1){
                                        map[yy][xx] = 0;
                                        queue.add(new int[]{xx, yy});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
