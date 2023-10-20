import java.awt.Point;
import java.util.*;

class Solution {
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    public int X, Y;
    
    public int[] solution(int Y, int X, int[][] picture) {
        this.X = X;
        this.Y = Y;
        
        int cnt = 0;
        int maxSize = 0;

        for(int y = 0; y < Y; y++){
            for(int x = 0; x < X; x++){
                if(picture[y][x] > 0){
                    int color = picture[y][x];
                    int size = 1;
                    Queue<Point> q = new LinkedList<>();
                    
                    cnt += 1;
                    
                    q.add(new Point(x, y));
                    picture[y][x] = -1;
                    
                    while(!q.isEmpty()){
                        Point now = q.poll();
                        
                        for(int i = 0; i < 4; i++){

                            int mx = now.x + dx[i];
                            int my = now.y + dy[i];

                            if(isRange(mx, my) && picture[my][mx] == color){
                                q.add(new Point(mx, my));
                                picture[my][mx] = -1;
                                size += 1;
                                maxSize = Math.max(maxSize, size);
                            }
                        }
                    }
                }
            }
        }
        return new int[] {cnt, maxSize};
    }
    
    public boolean isRange(int x, int y){
        return (x >= 0 && x < X && y >= 0 && y < Y);
    }
}