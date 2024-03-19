import java.util.*;
import java.io.*;

public class Main {
    public static class Node{
        int x;
        int y;
        int w;
        
        public Node(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int X, Y;
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int[][] map;
      boolean[][] isVisited;
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      X = Integer.parseInt(st.nextToken());
      Y = Integer.parseInt(st.nextToken());
      
      map = new int[Y][X];
      isVisited = new boolean[Y][X];
      
      for(int y = 0; y < Y; y++){
          String str = br.readLine();
          for(int x = 0; x < X; x++){
              map[y][x] = str.charAt(x) - 48;
          }
      }
      
      PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->{
          return Integer.compare(o1.w, o2.w);
      });
      
      int mx, my;
      
      pq.add(new Node(0, 0, 0));
      
      while(!pq.isEmpty()){
          Node now = pq.poll();
          
          if(now.x == X-1 && now.y == Y-1){
              System.out.println(now.w);
              break;
          }
          
          if(isVisited[now.y][now.x]){
              continue;
          }
          
          isVisited[now.y][now.x] = true;
          
          for(int i = 0; i < 4; i++){
              mx = now.x + dx[i];
              my = now.y + dy[i];
              
              if(!isRange(mx, my)){
                  continue;
              }
              if(isVisited[my][mx]){
                  continue;
              }
              
              if(map[my][mx] == 1){
                  pq.add(new Node(mx, my, now.w + 1));
              }
              else{
                  pq.add(new Node(mx, my, now.w));
              }
          }
       }
    }
    
    public static boolean isRange(int x, int y){
        return x >= 0 && x < X && y >= 0 && y < Y;
    }
}