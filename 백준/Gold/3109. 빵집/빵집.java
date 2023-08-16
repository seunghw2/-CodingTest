import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static int X;
	public static int Y;
	public static boolean[][] map;
	public static boolean isFound;
	
	public static int[] dy = {-1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		int ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new boolean[Y][X];
		
		for(int j = 0; j < Y; j++) {
			String line = br.readLine();
			for(int i = 0; i < X; i++) {
				if(line.charAt(i) == 'x') {
					map[j][i] = true;
				}
			}
		}

		for(int i = 0; i < Y; i++) {
			isFound = false;
			connect(0,i);
			if(isFound)
				ans += 1;
		}

		System.out.println(ans);
	}
	
	public static void connect(int x, int y) {
		int mx, my;
		
		if(x == X - 1) {
			isFound = true;
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			mx = x + 1;
			my = y + dy[i];
			if(isRange(mx, my)){
				if(map[my][mx] == false) {				
					map[my][mx] = true;
					connect(mx, my);
					
					if(isFound)
						break;
					
				}
			}
		}
	}
	
	public static boolean isRange(int x, int y) {
		return (x >= 0 && x < X && y >= 0 && y < Y);
	}
}