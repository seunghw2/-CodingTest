import java.io.*;
import java.util.*;

class Main {
	public static int cnt = 0;
	
	public static int[] dx = {-1, 0, 0, 1};
	public static int[] dy = {0, -1, 1, 0};
	
	public static boolean isRange(char[][] campus, int N, int M, int x, int y) {
		if(x >= 0 && x < M && y >= 0 && y < N)
			return true;
		return false;
	}
	
	public static void dfs(char[][] campus, int N, int M, int x, int y) {
		int mx, my;
		campus[y][x] = 'X';
		
		for(int i = 0; i < 4; i++) {
			mx = x + dx[i];
			my = y + dy[i];
			
			if(isRange(campus, N, M, mx, my)) {
				if(campus[my][mx] != 'X') {
					if(campus[my][mx] == 'P')
						cnt ++;
					dfs(campus, N, M, mx, my);
				}
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        char campus[][];
        int startx = -1;
        int starty = -1;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new char[N][M];
        
        for(int i = 0; i < N; i++) {
        	String line = br.readLine();
        	for(int j = 0; j < M; j++) {
        		campus[i][j] = line.charAt(j);
        		if(campus[i][j] == 'I') {
        			startx = j;
        			starty = i;
        		}
        	}
        }
        
        dfs(campus, N, M, startx, starty);
        if(cnt == 0)
        	System.out.println("TT");
        else
        	System.out.println(cnt);
    }
}