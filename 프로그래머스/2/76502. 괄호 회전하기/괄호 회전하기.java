import java.util.*;

class Solution {
    public static char[] arr = {'{', '[', '(', '}', ']', ')'};
    
    public int solution(String s) {
        int answer = 0;
        Stack<Integer> stack;
        boolean suc;
        
        for(int start = 0; start < s.length(); start++){
            stack = new Stack<>();
            suc = true;

            for(int i = start; i < start + s.length(); i++){
                char now;
                boolean open = true;
                int idx = -1;
                
                if(i < s.length()){
                    now = s.charAt(i);
                }
                else{
                    now = s.charAt(i - s.length());
                }
                
                for(int j = 0; j < 6; j++){
                    if(arr[j] == now){
                        idx = j;
                        if(j >= 3)
                            open = false;
                    }
                }
                
                if(open){
                    stack.add(idx);
                }
                else{
                    if(!stack.isEmpty()){
                        int prev = stack.peek();
                        if(idx - prev == 3){
                            stack.pop();
                        }
                        else{
                            suc = false;
                            break;
                        }
                    }
                    else{
                        suc = false;   
                        break;
                    }
                }
            }
            if(suc && stack.size() == 0){
                answer += 1;
            }
        }
        
        return answer;
    }
}