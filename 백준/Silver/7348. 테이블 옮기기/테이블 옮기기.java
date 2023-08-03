import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int T, N, s, tmp;
        int a, b;
        int maxV;
        int[] arr;

        StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            arr = new int[200];

            N = Integer.parseInt(br.readLine());
            for(int n = 0; n < N; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                a = (a % 2 == 0) ? (a / 2) - 1 : a / 2;
                b = (b % 2 == 0) ? (b / 2) - 1 : b / 2;
                if(a > b){
                    tmp = a;
                    a = b;
                    b = tmp;
                }

                for(int i = a; i <= b; i++) {
                    arr[i] += 1;
                }
            }

            maxV = Integer.MIN_VALUE;
            for(int i = 0; i < 200; i++) {
                if(arr[i] >= maxV)
                    maxV = arr[i];
            }
            sb.append(maxV * 10).append("\n");

        }
        System.out.println(sb);
    }
}