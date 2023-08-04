import java.util.*;
import java.io.*;

public class Main {
    public static Stack<Integer> stack = new Stack<>();
    public static int N;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(0, 0);
        System.out.println(sb);
    }

    public static boolean isPrime(int number){
    	if(number < 2)
    		return false;
    	
        int sqrt = (int) Math.sqrt(number);
        for(int i = 2; i <= sqrt; i++){
            if(number % i == 0)
                return false;
        }
        return true;
    }
    
    public static void dfs(int num, int depth) {
    	int newNum;
    	
    	if(depth == N) {
    		sb.append(num).append("\n");
    		return;
    	}
    	for(int i = 0; i < 10; i++) {
    		newNum = num * 10 + i;
    		if(isPrime(newNum))
    			dfs(newNum, depth + 1);
    	}
    }
}