import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
	public static int N, cnt;
	public static int[][] isVisited;
	public static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	public static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		isVisited = new int[N][N];
		
		queen(0);
		
		System.out.println(cnt);
    }
    
    public static void queen(int y) {
    	if(y == N) {
    		cnt += 1;
    		return;
    	}
    	for(int x = 0; x < N; x++) {
    		if(isVisited[y][x] != 0)
    			continue;
    		markVisit(x, y, 1);
    		queen(y+1);
    		markVisit(x, y, -1);
    	}
    }
    
    public static void markVisit(int x, int y, int visit) {
    	for(int i = 0; i < 8; i++) {
    		int mx = x;
    		int my = y;
    		
    		while(isRange(mx, my)) {
    			isVisited[my][mx] += visit;
    			mx += dx[i];
    			my += dy[i];
    		}
    	}
    }

    public static boolean isRange(int x, int y) {
    	return x >= 0 && x < N && y >= 0 && y < N;
    }
}