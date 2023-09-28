import java.io.*;
import java.util.*;

public class Main {
    public static int N, S;
    public static int[] arr;
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] >= S){
                System.out.println(1);
                System.exit(0);
            }
        }

        twoPointer();

        if(ans == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(ans);

    }

    public static void twoPointer(){
        int left = 0;
        int right = 0;
        int sum = arr[0];


        while(true){
            if(sum >= S){
                ans = Math.min(ans, right - left + 1);
                sum -= arr[left];
                left += 1;
            }
            else{
                right += 1;
                if(right == N)
                    break;
                sum += arr[right];
            }
        }
    }
}