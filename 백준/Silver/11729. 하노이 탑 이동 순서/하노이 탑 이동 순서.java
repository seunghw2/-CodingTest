import java.io.*;
import java.util.*;

class Main {
	public static StringBuilder sb = new StringBuilder();
	
	public static void hanoi(int start, int mid, int end, int height) {
		if(height == 1) {
			sb.append(start + " "+ end + "\n");
			return;
		}
		
		hanoi(start, end, mid, height - 1);
		sb.append(start + " " + end + "\n");
		hanoi(mid, start, end, height - 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		hanoi(1, 2, 3, K);
		System.out.println((int)(Math.pow(2, K)-1));
		System.out.println(sb);
	}
}