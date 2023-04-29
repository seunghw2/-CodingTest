import java.util.*;
        // for(int[] item: queue){
        //     System.out.println(item[0] + " " + item[1]);               
        // }

class Solution {    
    public int solution(int[][] maps) {
        int[] ww = {1, 0, 0, -1};
        int[] hh = {0, 1, -1, 0};
        
        int maph = maps.length;
        int mapw = maps[0].length;
        int answer = 0;
        
        Queue<int[]> queue = new LinkedList<int[]>();
        int[][] Visited = new int[maph][mapw];
        
        int h = 0;
        int w = 0;
        int depth = 1;
        
        int[] item = {h, w, depth};     // h w depth
        queue.add(item);
        
        while (!queue.isEmpty()) {
            item = queue.poll();
            h = item[0];
            w = item[1];
            depth = item[2];
            
            if(h == maph - 1 && w == mapw - 1){
                answer = depth;
                return answer;
            }
            
            for(int i=0; i < 4; i++){
                if(h+hh[i] >= 0 && h+hh[i] < maph && w+ww[i] >= 0 && w+ww[i] < mapw){
                    if(maps[h+hh[i]][w+ww[i]] == 1){
                        if(Visited[h+hh[i]][w+ww[i]] == 0){
                            item = new int[]{h+hh[i], w+ww[i], depth+1};
                            queue.add(item);
                            Visited[h+hh[i]][w+ww[i]] = 1;
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}