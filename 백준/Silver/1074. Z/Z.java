import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int startx = 0;
		int starty = 0;
		int cntx, cnty;
		int res = 0;
		
		while(N >= 1) {
			if(x >= startx && x < startx + Math.pow(2, N-1))
				cntx = 0;
			else
				cntx = 1;
			
			if(y >= starty && y < starty + Math.pow(2, N-1))
				cnty = 0;
			else
				cnty = 1;
			
			res += (cnty * 2 + cntx) * Math.pow(2, 2*N-2);
			
			startx += cntx * Math.pow(2, N-1);
			starty += cnty * Math.pow(2, N-1);
			N -= 1;
		}
		
		System.out.println(res);
	}
}