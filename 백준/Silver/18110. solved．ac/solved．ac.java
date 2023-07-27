import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int num = -1;
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		num = (int) Math.round((double)n * 0.15);
		
		for(int i = num; i < n - num; i++) {
			sum += arr[i];
		}
		
		System.out.println((int) Math.round((double)sum / (n - 2 * num)));
	}
}