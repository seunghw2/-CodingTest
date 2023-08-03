import java.io.*;
import java.util.*;


public class Main {
	static class Node{
		int idx;
		int cost;
		
		Node(int end, int cost){
			this.idx = end;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		int N, M;
		int start, end, cost;
		int idx;
		int[] minCost;
		Node curNode, nextNode;
		
		List<List<Node>> graph = new ArrayList<>();

		Queue<Node> pq = new LinkedList<>();
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		for(int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<>());
		}
		minCost = new int[N + 1];
		Arrays.fill(minCost, Integer.MAX_VALUE);

		for (int m = 0; m < M; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());

			graph.get(start).add(new Node(end, cost));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		minCost[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			curNode = pq.poll();
			
			if(minCost[curNode.idx] < curNode.cost) {
				continue;
			}
			
			for(int i = 0; i < graph.get(curNode.idx).size(); i++) {
				nextNode = graph.get(curNode.idx).get(i);
				
				if(minCost[nextNode.idx] > curNode.cost + nextNode.cost) {
					minCost[nextNode.idx] = curNode.cost + nextNode.cost;
					pq.add(new Node(nextNode.idx, minCost[nextNode.idx]));
				}
			}
		}

//		System.out.println(Arrays.toString(minCost));
		System.out.println(minCost[end]);
		
	}
}