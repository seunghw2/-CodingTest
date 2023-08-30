import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static long n;
    public static final long remainder = 1_000_000_007;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        long[][] mat = {{1, 1}, {1, 0}};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Long.parseLong(br.readLine());

        if(n == 0)
            System.out.println(0);
        else if(n == 1)
            System.out.println(1);
        else
            System.out.println(calcAll(n-1, mat)[0][0]);
    }

    private static long[][] calcAll(long B, long[][] mat) {
        long[][] divMat;
        long[][] calcMat;

        if(B == 1)
            return mat;

        divMat = calcAll(B/2, mat);
        calcMat = calcOne(divMat, divMat);

        if(B % 2 == 0){
            return calcMat;
        }
        else{
            return calcOne(calcMat, mat);
        }
    }

    public static long[][] calcOne(long[][] A, long[][] B) {
        long[][] ret = new long[2][2];

        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 2; x++) {
                for (int i = 0; i < 2; i++) {
                    ret[y][x] += A[y][i] * B[i][x];
                }
                ret[y][x] %= remainder;
            }
        }
        return ret;
    }
}