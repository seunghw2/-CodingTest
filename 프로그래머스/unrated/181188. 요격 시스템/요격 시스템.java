import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int right = 0;
        int tmp;
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> {
            return o1[0] - o2[0];
            });
        
        for(int[] target: targets){
            if(target[0] >= right){
                answer += 1;
                right = target[1];
            }
            else{
                right = Math.min(right, target[1]);
            }
        }
        
        // System.out.println(Arrays.deepToString(targets));
        
        
        
        return answer;
    }
}