import java.util.*;
import java.io.*;

public class Main{
    public static int n, m;
    public static int[] cals;
    public static int[] coins;
    public static int[] maps;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
        
            n = Integer.parseInt(st.nextToken());
            m = (int)(Double.parseDouble(st.nextToken()) * 100);
        
            if(n == 0 && m == 0)
                break;
        
            coins = new int[n+1];
            cals = new int[n+1];
            maps = new int[m+1];    
            
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                
                cals[i+1] = Integer.parseInt(st.nextToken());
                coins[i+1] = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.1);
            }
            
            getCals();
            
            sb.append(maps[m]).append('\n');
        }
        System.out.println(sb);
    }
    
    public static void getCals(){
        for(int y = 1; y <= n; y++){
            for(int x = 0; x <= m; x++){
                if(x - coins[y] < 0)
                    continue;
                else
                    maps[x] = Math.max(maps[x], maps[x-coins[y]] + cals[y]);
            }
        }
    }
    
    public static void print(){
        for(int y = 0; y <= n; y++){
            for(int x = 0; x <= m; x+= 100){
                System.out.print(maps[x] + " ");
            }
            System.out.println();
        }
    }
}