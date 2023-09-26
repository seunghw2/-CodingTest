import java.io.*;
import java.util.*;

public class Main {
    public static long a, b;
    public static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int M, N, S;
        long c;
        long res = 0;

        M = Integer.parseInt(br.readLine());
        for(int m = 0; m < M; m++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            a = S;
            b = N;
            c = pow(MOD - 2);

            res += (a * c % MOD);
            res %= MOD;
        }
        System.out.println(res);
    }

    public static long pow(long x){
        long calc, ret;

        if(x == 1)
            return b;

        calc = pow((long)(x / 2));
        ret = calc * calc % MOD;

        if(x % 2 == 0)
            return ret;
        else
            return ret * b % MOD;
    }
}