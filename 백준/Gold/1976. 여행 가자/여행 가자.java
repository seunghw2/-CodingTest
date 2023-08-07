import java.io.*;
import java.util.*;

public class Main {
	public static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		int N, M;
		int[][] cities;
		Set<Integer> travel = new HashSet<>();
		Set<Integer> ans = new HashSet<>();
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		cities = new int[N+1][N+1];
		parent = new int[N+1];
		
		
		// 입력
		for(int j = 1; j < N+1; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i < N+1; i++)
				cities[j][i] = Integer.parseInt(st.nextToken());
		}
//
//		if(M == 0) {
//			System.out.println("YES");
//			System.exit(0);
//		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++)
			travel.add(Integer.parseInt(st.nextToken()));
		
		// 구현
		for(int i = 0; i < N+1; i++)
			parent[i] = i;
		
		for(int city1 = 1; city1 < N+1; city1++) {
			for(int city2 = 1; city2 < N+1; city2++) {
				if(cities[city1][city2] == 1) {
					unionParent(city1, city2);
//					System.out.println(Arrays.toString(parent));
				}
			}
		}

		for(int i = 1; i < N+1; i++) {
			if(travel.contains(i)) {
				ans.add(getParent(i));
			}
		}
		
//		System.out.println(ans);
		
		if(ans.size() == 1)
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}

	private static int getParent(int city) {
		if(parent[city] == city)
			return city;
		else
			return(getParent(parent[city]));
	}
	
	private static void unionParent(int city1, int city2) {
		int parent1 = getParent(city1);
		int parent2 = getParent(city2);
		
		if(parent1 < parent2)
			parent[parent2] = parent1;
		else
			parent[parent1] = parent2;
	}
}