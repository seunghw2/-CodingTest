import java.io.*;
import java.util.*;

public class Main {
	public static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		int N, M, T;
		int x, y;
		int num;
		int idx;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if(o1[1] != o2[1])
				return o1[1] - o2[1];
			else
				return o1[0] - o2[0];
		});
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			if(y >= 0 && y <= N && x >= 0 && x <= M) {
				pq.add(new int[] {x, y});
			}
		}
		
		while(!pq.isEmpty()) {
			num = pq.poll()[0];
			
			idx = bisearch(num);
			if(idx == list.size())
				list.add(num);
			else
				list.set(idx, num);
			
		}
		System.out.println(list.size());
		
	}
	
	public static int bisearch(int target) {
		int lo = 0;
		int mid;
		int hi = list.size();
		
		while(lo < hi) {
			mid = (lo + hi) / 2;
			
			if(target >= list.get(mid))
				lo = mid + 1;
			else
				hi = mid;
		}
		
		return lo;
	}
}