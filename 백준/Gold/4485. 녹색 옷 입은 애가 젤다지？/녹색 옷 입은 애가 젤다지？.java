import java.io.*;
import java.util.*;

public class Main {
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static int N;
	public static int[][] map, dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		
		while(true) {
			
			N = Integer.parseInt(br.readLine());
			
			if(N == 0)
				break;
			
			map = new int[N][N];
			dist = new int[N][N];
			
			for(int y = 0; y < N; y++) {
				Arrays.fill(dist[y], Integer.MAX_VALUE);
			}
			
			for(int y = 0; y < N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int x = 0; x < N; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			dijkstra();
			
			System.out.println("Problem " + (++cnt) + ": " + dist[N-1][N-1]);
		}
	}
	
	public static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		
		dist[0][0] = map[0][0];
		pq.add(new int[] {0, 0, dist[0][0]});
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int x = now[0];
			int y = now[1];
			int d = now[2];
			
			if(d > dist[y][x])
				continue;
			
			for(int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				
				if(!isRange(mx, my))
					continue;
				
				int tmp = dist[y][x] + map[my][mx];
				
				if(dist[my][mx] > tmp) {
					dist[my][mx] = tmp;
					pq.add(new int[] {mx, my, dist[my][mx]});
				}
			}
		}
	}
	
	public static boolean isRange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}
}