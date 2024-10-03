import java.io.*;
import java.util.*;

public class Main {
	public static int X, Y;
	public static boolean[][] map;
	public static int ans;
	
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new boolean[Y][X];
		
		for(int y = 0; y < Y; y++) {
			String s = br.readLine();
			
			for(int x = 0; x < X; x++) {
				if(s.charAt(x) == 'L') {
					map[y][x] = true;
				}
			}
		}
		
		for(int y = 0; y < Y; y++) {
			for(int x = 0; x < X; x++) {
				if(!map[y][x])
					continue;
				bfs(x, y);
			}
		}
		
		System.out.println(ans);
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		
		boolean[][] isVisited = new boolean[Y][X];
		
		q.add(new int[] {x, y, 0});
		isVisited[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nx = now[0];
			int ny = now[1];
			int nd = now[2];
			
			for(int i = 0; i < 4; i++) {
				int mx = nx + dx[i];
				int my = ny + dy[i];
				
				if(!isRange(mx, my))
					continue;
				if(!map[my][mx])
					continue;
				if(isVisited[my][mx])
					continue;
				
				q.add(new int[] {mx, my, nd + 1});
				isVisited[my][mx] = true;
				ans = Math.max(ans, nd + 1);
			}
		}
	}
	
	public static boolean isRange(int x, int y) {
		return x >= 0 && x < X && y >= 0 && y < Y;
	}
}