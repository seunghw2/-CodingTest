import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int cnt = 0;
        
        List<Integer> botList = new ArrayList<>();
        List<Integer> topList = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
        	int a = Integer.parseInt(br.readLine());
        	
        	if(i % 2 == 0)
        		botList.add(a);
        	else
        		topList.add(a);
        }
        
        int[] imos = new int[H+1];
        int[] sum = new int[H+1];
        
        for(int bot : botList) {
        	imos[0] += 1;
        	imos[bot] -= 1;
        }
        
        for(int top : topList) {
        	imos[H - top] += 1;
        	imos[H] -= 1;
        }
        
        sum[0] = imos[0];
        
        for(int i = 1; i <= H; i++) {
        	sum[i] = sum[i-1] + imos[i];
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < H; i++) {
        	min = Math.min(min, sum[i]);
        }
        

        
        for(int i = 0; i < H; i++) {
        	if(sum[i] == min) {
        		cnt += 1;
        	}
        }
        
        System.out.println(min + " " + cnt);
    }
}