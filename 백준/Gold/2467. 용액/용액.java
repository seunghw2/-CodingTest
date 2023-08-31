import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N;
        int lo, hi;
        int minV = Integer.MAX_VALUE;
        int i1, i2;
        int[] arr;

        N = Integer.parseInt(br.readLine());

        lo = 0;
        i1 = 0;
        hi = N - 1;
        i2 = N - 1;
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (lo < hi) {
            int val = arr[lo] + arr[hi];
            if (minV > Math.abs(val)) {
                minV = Math.abs(val);
                i1 = lo;
                i2 = hi;
            }

            if(val < 0){
                lo += 1;
            }
            else if(val == 0){
                break;
            }
            else
                hi -= 1;
        }

        if(i1 > i2)
            System.out.println(arr[i2] + " " + arr[i1]);
        else
            System.out.println(arr[i1] + " " + arr[i2]);
    }
}