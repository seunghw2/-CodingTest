import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		int N, d, k, c;
		int ans;
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		for(int i = 0; i < k; i++) {
			list.add(list.get(i));
		}
		
		// init
		map.put(c, 1);
		
		for(int i = 0; i < k; i++) {
			if(map.containsKey(list.get(i))) {
				int tmp = map.get(list.get(i));
				map.put(list.get(i), tmp + 1);
			}
			else {
				map.put(list.get(i), 1);
			}
		}
		
		ans = map.size();
		
		//
		for(int i = 0; i < N; i++) {
			int prev = list.get(i);
			if(map.get(prev) == 1)
				map.remove(prev);
			else
				map.put(prev, map.get(prev) - 1);
			
			int next = list.get(i + k);
			if(map.containsKey(next)) {
				int tmp = map.get(next);
				map.put(next, tmp + 1);
			}
			else {
				map.put(next, 1);
			}
			
			ans = Math.max(ans, map.size());
		}
		System.out.println(ans);
	}
}