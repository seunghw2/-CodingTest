import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int N, M, gender, num;
		int[] arr;

		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N+1];
		for(int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {
				for(int j = num; j < N+1; j+=num)
					arr[j] = (arr[j] == 1) ? 0 : 1;
			}
			if(gender == 2) {
				arr[num] = (arr[num] == 1) ? 0 : 1;
				for(int j = 1; num - j > 0 && num + j < N+1; j ++) {
					if(arr[num - j] == arr[num + j]) {
						arr[num - j] = (arr[num - j] == 1) ? 0 : 1;
						arr[num + j] = (arr[num + j] == 1) ? 0 : 1;
					}
					else
						break;
				}
			}
		}
		for(int i = 1; i < N+1; i++) {
			sb.append(arr[i] + " ");
			if(i % 20 == 0) {
				sb.delete(sb.length()-1, sb.length());
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}