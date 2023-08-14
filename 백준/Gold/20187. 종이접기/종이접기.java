import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int[][] holes = {
			{0, 1, 2, 3}, {1, 0, 3, 2}, {2, 3, 0, 1}, {3, 2, 1, 0}
			};	// 2 x 2 종이에서 생길 수 있는  구멍의 위치 (총 4개) 
	
	public static int K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input3.txt"));

		int h;
		int lastPos = -1;	// 종이를 다 접고 난 뒤에 마지막 구멍을 뚫는 1x1 종이의 상대적 위치
							// 0 : 2x2 종이의 좌상단, 1 : 우상단, 2 : 좌하단, 3 : 우하단 
		
		char cmd;
		char lastUD = 'x';	// 마지막에 종이를 위로 접었는지, 아래로 접었는지
		char lastLR = 'x';	// 마지막에 종이를 왼쪽으로 접었는지, 오른쪽로 접었는지
		
		K = Integer.parseInt(br.readLine());
		String[] cmds = br.readLine().split(" ");
		h = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < cmds.length; i++) {	// 마지막에 종이를 어떻게 접었는 지
			cmd = cmds[i].charAt(0);
			if(cmd == 'R' || cmd == 'L')
				lastLR = cmd;
			else if(cmd == 'U' || cmd == 'D')
				lastUD = cmd;
		}
		
		if(lastUD == 'U' && lastLR == 'L')		// 마지막에 종이를 어떻게 접었는지에 따라 마지막 종이의 상대적 위치를 알 수 있게 됨
			lastPos = 0;
		else if(lastUD == 'U' && lastLR == 'R')
			lastPos = 1;
		else if(lastUD == 'D' && lastLR == 'L')
			lastPos = 2;
		else if(lastUD == 'D' && lastLR == 'R')
			lastPos = 3;
		
		for(int i = 0; i < 4; i++) {
			if(holes[i][lastPos] == h) {
				printAns(i);
			}
		}
	}
	
	public static void printAns(int n) {
		StringBuilder sb = new StringBuilder();

		// 2 x 2 종이에서 구멍의 상대적 위치가 결정 된다면, 대칭에 의해 나머지 2x2 종이들의 구멍의 상대적 위치도 동일 
		for(int j = 0; j < Math.pow(2, K) / 2; j++) {
			for(int i = 0; i < Math.pow(2, K) / 2; i++) {
				sb.append(holes[n][0]).append(" ").append(holes[n][1]).append(" ");
			}
			sb.append("\n");
			for(int i = 0; i < Math.pow(2, K) / 2; i++) {
				sb.append(holes[n][2]).append(" ").append(holes[n][3]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}