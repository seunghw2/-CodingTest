import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[][] post, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        post = new int[N][N];
        res = new int[N][N];

        for(int i = 0; i < N; i++){
            Arrays.fill(post[i], 10000);
            Arrays.fill(res[i], 10000);
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            post[a][b] = c;
            post[b][a] = c;
            res[a][b] = b;
            res[b][a] = a;
        }

        floyd();

        print();
    }

    public static void floyd(){
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(post[i][j] > post[i][k] + post[k][j]){
                        post[i][j] = post[i][k] + post[k][j];
                        res[i][j] = res[i][k];
                    }
                }
            }
        }
    }

    public static void print(){
        for(int y = 0; y < N; y++){
            for(int x = 0; x < N; x++) {
                if(x == y)
                    System.out.print("- ");
                else
                    System.out.print(res[y][x]+1 + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}