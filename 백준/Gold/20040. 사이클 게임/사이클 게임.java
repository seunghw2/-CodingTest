import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n, m;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parents = new int[n];
		for(int i = 0; i < n; i++)
			parents[i] = i;
		
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(!unionParent(a, b)) {
				System.out.println(i);
				System.exit(0);
			}
		}
		System.out.println(0);
	}
	
	public static int getParent(int num) {
		if(num == parents[num])
			return num;
		else
			return parents[num] = getParent(parents[num]);
	}
	
	public static boolean unionParent(int n1, int n2) {
		int p1 = getParent(n1);
		int p2 = getParent(n2);
		
		if(p1 == p2)
			return false;
		else {
			parents[p2] = p1;
			return true;
		}
	}
}