import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<>();
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {s, e});
		}
		
		list = list.stream()
					.sorted((a, b) -> a[0] - b[0])
					.collect(Collectors.toList());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.add(list.get(0)[1]);
		
		for(int n = 1; n < N; n++) {
			if(list.get(n)[0] >= pq.peek()) {
				pq.poll();
			}
			pq.add(list.get(n)[1]);
		}
		
		System.out.println(pq.size());
    }
}