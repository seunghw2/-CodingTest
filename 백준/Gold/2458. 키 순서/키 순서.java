import java.io.*;
import java.util.*;

public class Main {
    public static int[][] dist;
    public static int N, M;
    public static final int MAX = 1000;
    
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        
        boolean suc;
        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        dist = new int[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(dist[i], MAX);
            dist[i][i] = 0;
        }
            
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            
            dist[a][b] = 1;
        }
        
        floyd();
        
        // for(int i = 0; i < N; i++){
        //     System.out.println(Arrays.toString(dist[i]));
        // }
        
        for(int i = 0; i < N; i++){
            suc = true;
            for(int j = 0; j < N; j++){
                if(dist[j][i] == MAX && dist[i][j] == MAX){
                    suc = false;
                    break;
                }
            }
            if(suc){
                ans += 1;
            }
        }
        
        System.out.println(ans);
    }
    
    public static void floyd(){
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}