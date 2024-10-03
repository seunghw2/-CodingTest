import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, K;
	public static int[] cost, parent;
	public static int totCost;
	public static List<int[]> friList = new ArrayList<>();
	public static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		cost = new int[N+1];
		parent = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friList.add(new int[] {a, b});
		}
		
		while(true) {
			boolean isChanged = false;
			
			for(int[] fri : friList) {
				int a = fri[0];
				int b = fri[1];
				
				if(unionParent(a, b))
					isChanged = true;
			}
			
			if(!isChanged)
				break;
			
			for(int i = 0; i <= N; i++) {
				parent[i] = getParent(i);
			}
		}
		
//		System.out.println(Arrays.toString(parent));
		
		for(int i = 1; i <= N; i++) {
			int p = parent[i];
			if(!set.contains(p)) {
				set.add(p);
				totCost += cost[p];
			}
		}
		
//		System.out.println(totCost);
		
		if(totCost > K)
			System.out.println("Oh no");
		else
			System.out.println(totCost);
	}
	
	public static int getParent(int idx) {
		if(idx == parent[idx])
			return idx;
		return parent[idx] = getParent(parent[idx]);
	}
	
	public static boolean unionParent(int a1, int a2) {
		int p1 = getParent(a1);
		int p2 = getParent(a2);
		
		if(p1 == p2)
			return false;
		
		if(cost[p1] > cost[p2]) {
			parent[p1] = parent[p2];
			return true;
		}
		else {
			parent[p2] = parent[p1];
			return true;
		}
	}
}