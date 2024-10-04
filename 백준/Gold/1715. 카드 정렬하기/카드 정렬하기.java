import java.io.*;
import java.util.*;

public class Main { // BOJ에서 클래스 이름은 Main이어야 합니다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N, cnt;
        
        N = Integer.parseInt(br.readLine());
        cnt = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++) {
        	pq.add(Integer.parseInt(br.readLine()));
        }
        
    	while(pq.size() != 1) {
    		
        	int a = pq.poll();
        	int b = pq.poll();
        	
        	cnt += (a + b);
        	
        	pq.add(a+b);
        }
        
        System.out.println(cnt);
    }
}