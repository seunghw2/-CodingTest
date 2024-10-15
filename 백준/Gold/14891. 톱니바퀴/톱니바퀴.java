import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
	public static int[][] cycles = new int[4][8];
	public static List<int[]> list = new ArrayList<>();
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0; i < 4; i++) {
			String a = br.readLine();
			
			for(int j = 0; j < 8; j++) {
				cycles[i][j] = a.charAt(j) - '0';
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for(int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list = new ArrayList<>();
			
			int num = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {num, d});
			
			doLeft(num, d);
			doRight(num, d);
			
			for(int[] item: list) {
				
				if(item[1] == 1) {
					turnClock(item[0]);
				}
				else
					turnClockWise(item[0]);
			}
			
//			for(int i = 0; i < 4; i++)
//				System.out.println(Arrays.toString(cycles[i]));
		}
		
		int ans = 0;
		
		for(int i = 0; i < 4; i++)
			ans += Math.pow(2, i) * cycles[i][0];
		
		System.out.println(ans);
		
    }
    
    public static void doLeft(int now, int d) {
    	int next = now - 1;
    	
    	if(next < 0)
    		return;
    	
    	if(cycles[now][6] == cycles[next][2])
    		return;
    	
    	list.add(new int[] {next, d * (-1)});
    	
    	doLeft(next, d * (-1));
    }
    
    public static void doRight(int now, int d) {
    	int next = now + 1;
    	
    	if(next > 3)
    		return;
    	
    	if(cycles[now][2] == cycles[next][6])
    		return;
    	
    	list.add(new int[] {next, d * (-1)});

    	doRight(next, d * (-1));
    }
    
    public static void turnClock(int now) {
    	int tmp = cycles[now][7];
    	
    	for(int i = 7; i > 0; i--) {
    		cycles[now][i] = cycles[now][i-1];
    	}
    	
    	cycles[now][0] = tmp;
    }
    
    public static void turnClockWise(int now) {
    	int tmp = cycles[now][0];
    	
    	for(int i = 0; i < 7; i++) {
    		cycles[now][i] = cycles[now][i+1];
    	}
    	
    	cycles[now][7] = tmp;
    }
}