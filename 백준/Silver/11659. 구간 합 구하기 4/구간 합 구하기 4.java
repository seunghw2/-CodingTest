import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int N, M, start, end;
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N+1];
		int[] sum = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N+1; i++)
			num[i] = Integer.parseInt(st.nextToken());
		
		sum[1] = num[1];
		for(int i = 2; i < N+1; i++)
			sum[i] = sum[i-1] + num[i];

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			sb.append(sum[end] - sum[start-1]).append("\n");
		}
		System.out.println(sb);
	}
}