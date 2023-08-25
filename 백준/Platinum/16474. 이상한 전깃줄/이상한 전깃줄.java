import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, K;
	public static List<int[]> list = new ArrayList<>();
	public static List<Integer> lis = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		int idx;
		int num;
		int[] leftTmp;
		int[] rightTmp;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		leftTmp = new int[N+1];
		rightTmp = new int[M+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			leftTmp[tmp] = i;
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			rightTmp[tmp] = i;
		}
		
		K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new int[] {leftTmp[a], rightTmp[b]});
		}
		
		Collections.sort(list, (o1, o2) -> {
			if(o1[0] != o2[0])
				return Integer.compare(o1[0], o2[0]);
			else
				return -Integer.compare(o1[1], o2[1]);
		});
		
		for(int k = 0; k < K; k++) {
			num = list.get(k)[1];
				
			idx = bisearch(num);
			
			if(idx == lis.size())
				lis.add(num);
			else
				lis.set(idx, num);
		}
		System.out.println(K - lis.size());
	}

	private static int bisearch(int target) {
		int lo = 0;
		int mid;
		int hi = lis.size();

		while(lo < hi) {
			mid = (lo + hi) / 2;
			
			if(target > lis.get(mid))
				lo = mid + 1;
			else
				hi = mid;
		}
		return hi;
	}
	
}