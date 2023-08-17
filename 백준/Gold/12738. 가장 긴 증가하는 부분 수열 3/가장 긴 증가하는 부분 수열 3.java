import java.io.*;
import java.util.*;

public class Main {
	public static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		int N = Integer.parseInt(br.readLine());
		int idx;
		int num;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			idx = bisearch(num);
			
			if(idx == list.size())
				list.add(num);
			else
				list.set(idx, num);
			
		}
		System.out.println(list.size());
	}
	
	private static int bisearch(int target) {
		int lo = 0;
		int mid;
		int hi = list.size();
		
		while(lo < hi) {
			mid = (lo + hi) / 2;
			
			if(target > list.get(mid))
				lo = mid + 1;
			else
				hi = mid;
		}
		
		return lo;
	}
}