import java.io.*;
import java.util.*;

public class Main {
	private static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N;
		int idx;
		int num;
		int cnt;
		int[] nums;
		int[] order;
		int[] ans;
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		order = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			nums[i] = num;
			
			idx = bisearch(num);
			order[i] = idx;
			
			if(idx == list.size()) {
				list.add(num);
			}
			else
				list.set(idx, num);
		}
		
		cnt = list.size();
		System.out.println(cnt);
		
		ans = new int[cnt];
		
		for(int i = N - 1; i >= 0; i--) {
			if(order[i] == cnt - 1) {
				ans[cnt - 1] = nums[i];
				cnt -= 1;
			}
		}
		
		for(int item: ans)
			sb.append(item).append(' ');
		
		System.out.println(sb);
	}
	
	private static int bisearch(int num) {
		int lo = 0;
		int mid;
		int hi = list.size();
		
		while(lo < hi) {
			mid = (lo + hi) / 2;
			if(num > list.get(mid))
				lo = mid + 1;
			else
				hi = mid;
		}
		return hi;
	}
}