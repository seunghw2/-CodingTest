import java.io.*;
import java.util.*;

public class Main {
    public static int tot, X;
    public static Stack<Integer> stack = new Stack<>();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        X = Integer.parseInt(br.readLine());
        tot = 64;
        stack.push(tot);
        
        System.out.println(getStickCnt());
      
    }
    
    public static int getStickCnt(){
        int shortStick, halfStick;
        int cnt = 1;
        
        while(tot > X){
            shortStick = stack.pop();
            tot -= shortStick;
            cnt -= 1;
            
            halfStick = shortStick / 2;
            
            stack.push(halfStick);
            cnt += 1;
            tot += halfStick;
            
            if(tot < X){
                stack.push(halfStick);
                cnt += 1;
                tot += halfStick;
            }
        }
        
        return cnt;
    }
}