import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		int N;
		int x, y;
		int[][] paper = new int[100][100];
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			draw(paper, x, y);
		}
		
		System.out.println(count(paper));
	}
	
	public static void draw(int paper[][], int x, int y) {
		for(int j = y; j < y + 10; j++) {
			for(int i = x; i < x + 10; i++) {
				if(paper[j][i] == 0)
					paper[j][i] = 1;
			}			
		}
	}

	private static int count(int[][] paper) {
		int cnt = 0;
		
		for(int j = 0; j < 100; j++) {
			for(int i = 0; i < 100; i++) {
				if(paper[j][i] == 1)
					cnt += 1;
			}
		}
		return cnt;
	}
}