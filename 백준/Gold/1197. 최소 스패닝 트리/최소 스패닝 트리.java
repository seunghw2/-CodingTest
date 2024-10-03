import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
	public static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V, E;
		int tot;
		List<int[]> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		tot = 0;
		
		parent = new int[V+1];
		for(int i = 0; i <= V; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {a, b, w});
		}
		
		list = list.stream()
				.sorted((o1, o2) -> o1[2] - o2[2])
				.collect(Collectors.toList());
		
		for(int[] item: list) {
			int a = item[0];
			int b = item[1];
			int w = item[2];
			
			if(getParent(a) == getParent(b))
				continue;
			
			tot += w;
			unionParent(a, b);
		}
	
		System.out.println(tot);
	}
	
	public static int getParent(int idx) {
		if(idx == parent[idx])
			return idx;
		return parent[idx] = getParent(parent[idx]);
	}
	
	public static void unionParent(int i1, int i2) {
		int p1 = getParent(i1);
		int p2 = getParent(i2);
		
		if(p1 < p2) {
			parent[p1] = p2;
		}
		else {
			parent[p2] = p1;
		}
	}
}