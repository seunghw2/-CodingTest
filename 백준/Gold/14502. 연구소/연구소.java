import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int Y, X;
	public static int ans;
	
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {-1, 0, 1, 0};
	public static int[][] map;
	
	public static List<Point> virusList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new int[Y][X];
		
		for(int j = 0; j < Y; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < X; i++) {
				map[j][i] = Integer.parseInt(st.nextToken());
				if(map[j][i] == 2)
					virusList.add(new Point(i, j));
			}
		}
		
		dfs(0,0);
		
		System.out.println(ans);
	}
	
	public static void dfs(int num, int depth) {
		if(depth == 3) {
			int[][] mapCopy = new int[Y][X];
			
			for(int j = 0; j < Y; j++) {
				for(int i = 0; i < X; i++) {
					mapCopy[j][i] = map[j][i];
				}
			}
			
			ans = Math.max(ans, countSafeArea(mapCopy));
			return;
		}
		
		for(int next = num; next < Y*X; next++) {
			int x = next % X;
			int y = next / X;
			
			if(isRange(x, y) && map[y][x] == 0) {
				map[y][x] = 1;
				dfs(next, depth + 1);
				map[y][x] = 0;
			}
		}
	}
	
	public static int countSafeArea(int[][] arr) {
		int cnt = 0;
		
		for(Point virus: virusList) {
			spreadVirus(arr, virus.x, virus.y);
		}
		
		for(int[] items: arr) {
			for(int item: items) {
				if(item == 0)
					cnt ++;
			}
		}
		
		return cnt;
	}
	
	public static void spreadVirus(int[][] arr, int x, int y) {
		int mx, my;
		
		for(int i = 0; i < 4; i++) {
			mx = x + dx[i];
			my = y + dy[i];
			if(isRange(mx, my) && arr[my][mx] == 0) {
				arr[my][mx] = 2;
				spreadVirus(arr, mx, my);
			}
		}
	}
	
	public static boolean isRange(int x, int y) {
		return (x >= 0 && x < X && y >= 0 && y < Y);
	}
	
	public static void print(int[][] arr) {
		for(int[] items: arr) {
			for(int item: items) {
				System.out.print(item+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}