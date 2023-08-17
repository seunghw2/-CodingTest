import java.io.*;
import java.util.*;

public class Main {
	public static List<Integer> upList;
	public static List<Integer> downList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		int N;
		int idx;
		int num;
		int ans = 0;
		int[] nums;

		N = Integer.parseInt(br.readLine());
		nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			upList = new ArrayList<>();
			downList = new ArrayList<>();

			for (int j = 0; j < i; j++) {
				num = nums[j];
				
				if(num >= nums[i])
					continue;
				
				idx = bisearch(upList, num);
				
				if (idx == upList.size())
					upList.add(num);
				else
					upList.set(idx, num);
			}
			
			for (int j = N-1; j > i; j--) {
				num = nums[j];
				
				if(num >= nums[i])
					continue;
				
				idx = bisearch(downList, num);
				
				if (idx == downList.size())
					downList.add(num);
				else
					downList.set(idx, num);
			}
			
			ans = Math.max(ans, upList.size() + downList.size() + 1);
//			upList.add(nums[i]);
//
//			for(int x = downList.size() - 1; x >= 0; x--)
//				upList.add(downList.get(x));
//			
//			System.out.println(upList);
		}
		System.out.println(ans);
	}

	private static int bisearch(List<Integer> list, int target) {
		int lo = 0;
		int mid;
		int hi = list.size();

		while (lo < hi) {
			mid = (lo + hi) / 2;

			if (target > list.get(mid))
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;
	}
}