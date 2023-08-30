import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        long B;
        int[][] mat;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        mat = new int[N][N];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                mat[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        print(calcAll(B, mat));

        System.out.println(sb);
    }

    private static int[][] calcAll(long B, int[][] mat) {
        int[][] divMat;
        int[][] calcMat;

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

    public static int[][] calcOne(int[][] A, int[][] B) {
        int[][] ret = new int[N][N];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                for (int i = 0; i < N; i++) {
                    ret[y][x] += A[y][i] * B[i][x];
                }
                ret[y][x] %= 1000;
            }
        }

        return ret;
    }

    public static void print(int[][] arr){
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[j][i]%1000).append(" ");
            }
            sb.append("\n");
        }
    }
}