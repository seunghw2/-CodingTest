import java.io.*;
import java.util.*;

public class Main {
	public static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		int N, M;
		int inputCnt;
		int prev, now;
		int minParent;
		int ans = 0;
		boolean suc, isFalseExist;
		List<List<Integer>> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		
		for(int i = 0; i <= N; i++)
			parent[i] = i;
		for(int i = 0; i < M; i++) {
			list.add(new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine());
		inputCnt = Integer.parseInt(st.nextToken());
		for(int i = 0; i < inputCnt; i++) {
			parent[Integer.parseInt(st.nextToken())] = 0;
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			inputCnt = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < inputCnt; i++) {
				list.get(m).add(Integer.parseInt(st.nextToken()));
			}
			
			isFalseExist = false;
			minParent = Integer.MAX_VALUE;
			for(int item: list.get(m)) {
				if(getParent(item) == 0) {
					isFalseExist = true;
					break;
				}
				minParent = Math.min(minParent, getParent(item));
			}
			
			if(isFalseExist) {
				for(int item: list.get(m)) {
					parent[getParent(item)] = 0;
				}
			}
			else {
				for(int item: list.get(m)) {
					parent[getParent(item)] = minParent;
				}
			}
		}
		
		for(List<Integer> party: list) {
			suc = true;
			for(int person: party) {
				if(getParent(person) == 0) {
					suc = false;
					break;
				}
			}
			if(suc)
				ans += 1;
		}
		
		System.out.println(ans);
		
//		System.out.println(Arrays.toString(parent));
	}
	
	private static int getParent(int p) {
		if(parent[p] == p)
			return p;
		
		return getParent(parent[p]);
	}
}