import java.util.*;

class Solution {
    public static int[] arr = new int[11];
    public static int[] ans = new int[11];
    public static int scoreA, scoreB, maxGap;
    
    public int[] solution(int n, int[] info) {
        maxGap = 0;
        
        dfs(info, 0, n);
        
        if(maxGap == 0)
            return new int[] {-1};
        
        return ans;
    }
    
    public static void dfs(int[] info, int idx, int rem){
        if(idx == 11){
            getScore(info);
            
            if(scoreB - scoreA > maxGap){
                maxGap = scoreB - scoreA;
                for(int i = 0; i < 11; i++)
                    ans[i] = arr[i];
            }
            else if(scoreB - scoreA == maxGap){
                if(isAnswer()){
                    for(int i = 0; i < 11; i++)
                        ans[i] = arr[i];
                }
            }
            return;
        }
        for(int i = rem; i >= 0; i --){
            arr[idx] = i;
            dfs(info, idx + 1, rem - i);
        }
    }
    
    public static boolean isAnswer(){
        for(int i = 10; i >= 0; i--){
            if(arr[i] > ans[i])
                return true;
            else if(arr[i] < ans[i])
                return false;
        }
        return false;
    }
    
    public static void getScore(int[] info){
        scoreA = 0;
        scoreB = 0;
        
        for(int i = 0; i <= 10; i++){
            if(info[i] >= arr[i]){
                if(info[i] != 0){
                    scoreA += (10 - i);
                }
            }
            else{
                scoreB += (10 - i);
            }
        }
    }
}