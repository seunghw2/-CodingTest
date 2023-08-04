import java.io.*;
import java.util.*;

public class Main {
	public static List<Stack<Integer>> list = new ArrayList<>();
	public static Stack<Integer> stack = new Stack<>();
	public static boolean[] isVisited;
	public static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] sours, bitters;
		int sour, bitter;
		int dif;
		int minDif = Integer.MAX_VALUE;
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		N = Integer.parseInt(br.readLine());
		sours = new int[N];
		bitters = new int[N];
		isVisited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sours[i] = Integer.parseInt(st.nextToken()); 
			bitters[i] = Integer.parseInt(st.nextToken()); 
		}

		for(int i = 1; i <= N; i++) {
			combination(0, i, 0);
			
			for(Stack<Integer> idxes: list) {
				sour = 1;
				bitter = 0;
				
				for(int idx: idxes) {
					sour *= sours[idx];
					bitter += bitters[idx]; 
				}
				
				dif = Math.abs(sour - bitter);
				minDif = (minDif <= dif) ? minDif : dif;
			}
		}
		
		System.out.println(minDif);
	}
	
	public static void combination(int n, int r, int depth) {
		if(depth == r) {
			Stack<Integer> newStack = new Stack<>();
			newStack.addAll(stack);
			list.add(newStack);
			return;
		}
		for(int i = n; i < N; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				stack.add(i);
				combination(i, r, depth+1);
				stack.pop();
				isVisited[i] = false;
			}
		}
		
	}
}