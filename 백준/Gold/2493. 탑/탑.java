import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N;
        int idx;
        int[] arr, res;
        boolean isValid;
        Stack<Integer> stack = new Stack<>();

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        res = new int[N];
        for(int i= 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N-1; i >= 0; i--){
        	while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
        		res[stack.peek()] = i+1;
        		stack.pop();
        	}
        	stack.add(i);
        }
        
        isValid = false;
        for(int item: res)
            if(item != 0){
                isValid = true;
                break;
            }

        if(isValid)
            for(int item: res)
                sb.append(item).append(" ");
        else
            sb.append(0);

        System.out.println(sb);
    }
}