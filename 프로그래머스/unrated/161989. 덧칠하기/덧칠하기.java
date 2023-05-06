import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int next = section[0] + m;
        answer = 1;
        
        for(int x: section){
            if(x < next){
                continue;
            }
            else{
                next = x + m;
                answer += 1;
            }
        }
        
        return answer;
    }
}