import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

import static java.lang.System.exit;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int arr[] = new int[X];
        int sum[] = new int[X-N+1];
        int maxVal = -1;
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < X; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[0] = 0;
        for(int i = 0; i < N; i++){
            sum[0] += arr[i];
        }

        for(int i = 1; i < X-N+1; i++){
            sum[i] = sum[i-1] - arr[i-1] + arr[i+N-1];
        }

        for(int i = 0; i < X-N+1; i++){
            maxVal = Math.max(maxVal, sum[i]);
        }

        for(int i = 0; i < X-N+1; i++){
            if(sum[i] == maxVal)
                cnt += 1;
        }

        if(maxVal == 0)
            System.out.println("SAD");
        else{
            System.out.println(maxVal);
            System.out.println(cnt);
        }
    }
}