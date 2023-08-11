import java.io.*;
import java.util.*;

public class Main {
	public static List<Integer> list = new ArrayList<>();
	public static int[] arr = new int[9];
	public static int[] brr = new int[7];
	public static boolean[] isVisited = new boolean[9];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(0, 0, 0);
	}
	
	public static void dfs(int num, int depth, int sum) {
		if(depth == 7) {
			if(sum == 100) {
				for(int i = 0; i < 7; i++)
					System.out.println(list.get(i));
				System.exit(0);
			}
			return;
		}
		for(int i = num; i < 9; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				list.add(arr[i]);
				dfs(i, depth + 1, sum + arr[i]);
				list.remove(list.size() - 1);
				isVisited[i] = false;
			}
		}
	}
}