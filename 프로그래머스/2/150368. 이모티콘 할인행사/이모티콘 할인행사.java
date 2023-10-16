import java.util.*;

class Solution {
    public static int N, M;
    
    public static int[] sale = {10, 20, 30, 40};
    public static List<List<Integer>> permutations = new ArrayList<>();
    public static Stack<Integer> stack = new Stack<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
        int userVal, totVal;
        int cnt;
        int maxUser = 0;
        int maxVal = 0;
        
        N = users.length;
        M = emoticons.length;
        
        getPermutation(0);
        
        for(List<Integer> permutation: permutations){
            cnt = 0;
            totVal = 0;
            
            for(int[] user: users){
                userVal = getUserVal(user, emoticons, permutation);
                
                if(user[1] > userVal)
                    totVal += userVal;
                
                if(user[1] <= userVal){
                    cnt += 1;
                }
            }
            
            if(cnt == maxUser && totVal > maxVal){
                maxVal = totVal;
            }
            if(maxUser < cnt){
                maxUser = cnt;
                maxVal = totVal;
            }
        }
        
        int[] answer = {maxUser, maxVal};

        return answer;
    }
    
    
    
    public static int getUserVal(int[] user, int[] emoticons, List<Integer> permutation){
        int tot = 0;
        
        for(int i = 0; i < M; i++){
            if(user[0] <= sale[permutation.get(i)]){
                tot += emoticons[i] * (100 - sale[permutation.get(i)]) / 100;
            }
        }
        
        return tot;
    }
    
    public static double getTotVal(List<Integer> permutation, int[] emoticons){
        double tot = 0;
        
        for(int m = 0; m < M; m++){
            tot += emoticons[m] * (100 - sale[permutation.get(m)]) / 100;
        }
        
        return tot;
    }
    
    public static void getPermutation(int depth){
        if(depth == M){
            List<Integer> list = new ArrayList<>();
            for(int item: stack){
                list.add(item);
            }
            permutations.add(list);
            return;
        }
        for(int i = 0; i < 4; i++){
            stack.add(i);            
            getPermutation(depth+1);
            stack.pop();            
        }
    }
}