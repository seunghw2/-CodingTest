import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long totDist = 0;
        long curDist;
        
        int delIdx = n - 1;
        int picIdx = n - 1;
        int delBox;
        int totDelBox = 0;
        int totRetBox = 0;
        
        for(int i = 0; i < n; i++){
            totDelBox += deliveries[i];
            totRetBox += pickups[i];
        }
        
        while(totDelBox > 0 || totRetBox > 0){
            curDist = 0;
            delBox = (totDelBox < cap) ? totDelBox : cap;
            
            for(int i = delIdx; i >= 0; i--){
                if(deliveries[i] > 0)    
                    curDist = Math.max(curDist, i + 1);
                
                if(delBox >= deliveries[i]){
                    delBox -= deliveries[i];
                    totDelBox -= deliveries[i];
                    deliveries[i] = 0;
                }
                else{
                    deliveries[i] -= delBox;
                    totDelBox -= delBox;
                    delBox = 0;
                    delIdx = i;
                    break;
                }
            }
            
            for(int i = picIdx; i >= 0; i--){
                if(pickups[i] > 0)
                    curDist = Math.max(curDist, i + 1);
                
                if((cap - delBox) >= pickups[i]){
                    delBox += pickups[i];
                    totRetBox -= pickups[i];
                    pickups[i] = 0;
                }
                else{
                    pickups[i] -= (cap - delBox);
                    totRetBox -= (cap - delBox);
                    delBox = 0;
                    picIdx = i;
                    break;
                }
            }
            totDist += curDist * 2;
        }
        
        return totDist;
    }
}