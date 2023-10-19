import java.util.*;

class Solution {
    public String solution(String p) {
        StringBuilder answer = new StringBuilder();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < p.length(); i++){
            sb.append(p.charAt(i));
        }
        
        answer = getAns(sb);
        
        return answer.toString();
    }
    
    public StringBuilder getAns(StringBuilder sb){
        StringBuilder u, v, ans;
        ans = new StringBuilder();
        
        if(sb.length() == 0){
            return ans;
        }
        
        StringBuilder[] uv = getUV(sb);
        u = uv[0];
        v = uv[1];
        
        if(isRight(u)){
            ans.append(u);
            ans.append(getAns(v));
        }
        else{
            ans.append(convertU(u, v));
        }
        
        return ans;
    }
    
    public StringBuilder convertU(StringBuilder u, StringBuilder v){
        StringBuilder sb = new StringBuilder();
        
        sb.append('(');
        sb.append(getAns(v));
        sb.append(')');
            
        for(int i = 1; i < u.length() - 1; i++){
            char now = u.charAt(i);
            if(now == '('){
                sb.append(')');
            }
            else{
                sb.append('(');
            }
        }
        
        return sb;
    }
    
    public boolean isRight(StringBuilder u){
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < u.length(); i++){
            char now = u.charAt(i);
            
            if(now == '('){
                stack.add(now);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek() == '('){
                    stack.pop();
                }
                else return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    
    public StringBuilder[] getUV(StringBuilder sb){
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        
        int open = 0;
        int close = 0;
        
        boolean uu = true;
        
        for(int i = 0; i < sb.length(); i++){
            char now = sb.charAt(i);
            
            if(now == '(')
                open += 1;
            else
                close += 1;
            
            if(i == 0){
                u.append(now);
                
            }
            else{
                if(uu){
                    u.append(now);

                    if(open == close){
                        uu = false;
                    }
                }
                else{
                    v.append(now);
                }                
            }
        }
        
        return new StringBuilder[] {u, v};
    }
}