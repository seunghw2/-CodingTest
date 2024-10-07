import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
	public static int ans, X, Y;
	public static int[][] map;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {-1, 0, 1, 0};
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new int[Y][X];
		
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < X; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		clean(x, y, d);
		
		System.out.println(ans);
    }
    
    public static void clean(int x, int y, int d) {
    	if(map[y][x] == 0) {
    		ans += 1;
    		map[y][x] = -1;
    	}
    	
		boolean suc = false;
		
		for(int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if(isRange(mx, my) && map[my][mx] == 0) {
				suc = true;
				break;
			}
		}
		
		if(!suc) {
			int bx = x - dx[d];
			int by = y - dy[d];
			
			if(isRange(bx, by) && map[by][bx] != 1) {
				clean(bx, by, d);
				return;
			}
			else
				return;
		}
		else {
			d = (d + 3) % 4;
			
			int mx = x + dx[d];
			int my = y + dy[d];
			
			if(isRange(mx, my) && map[my][mx] == 0) {
				clean(mx, my, d);
				return;
			}
			else {
				clean(x, y, d);
			}
		}
    }
    
    public static boolean isRange(int x, int y) {
    	return x >= 0 && x < X && y >= 0 && y < Y;
    }
}