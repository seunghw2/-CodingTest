import java.io.*;
import java.util.*;

public class Main {
	public static List<Integer> finalList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringBuilder sb = new StringBuilder();
		
		int N;
		List<int[]> oriList = new ArrayList<>();
		int a, b;
		int numA;
		int numB;
		int idx;
		int cur;
		
		int[] numAB;
		int[] orders;
		
		N = Integer.parseInt(br.readLine());
		orders = new int[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			oriList.add(new int[] {a, b});
		}
		
		Collections.sort(oriList, (x1, x2) -> {
			return x1[0] - x2[0];
		}); 
		
		for(int i = 0; i < N; i++) {
			numAB = oriList.get(i);
			numA = numAB[0];
			numB = numAB[1];
			
			idx = bisearch(numB);
			orders[i] = idx;
			
			if(idx == finalList.size())
				finalList.add(numB);
			else
				finalList.set(idx,  numB);
		}
		
//		System.out.println(finalList);
		
		cur = finalList.size() - 1;
		for(int i = N-1; i >=0; i--) {
			if(orders[i] == cur) {
				orders[i] = -1;
				cur -= 1;
			}
		}
		
		System.out.println(N - finalList.size());
		for(int i = 0; i < N; i++) {
			if(orders[i] != -1)
				sb.append(oriList.get(i)[0]).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int bisearch(int num) {
		int lo = 0;
		int mid;
		int hi = finalList.size();
		
		while(lo < hi) {
			mid = (lo + hi) / 2;
			
			if(num > finalList.get(mid))
				lo = mid + 1;
			else
				hi = mid;
		}
		return hi;
	}
}