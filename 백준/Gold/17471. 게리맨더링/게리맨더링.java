import java.io.*;
import java.util.*;

public class Main {
	public static List<Set<Integer>> setList = new ArrayList<>();
	public static Set<Integer> numberSet = new HashSet<>();
	public static List<List<Integer>> graph = new ArrayList<>();
	public static int N;
	public static int[] people;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		int minDif = Integer.MAX_VALUE;

		N = Integer.parseInt(br.readLine());

		people = new int[N + 1];
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int end = Integer.parseInt(st.nextToken());

			for (int j = 0; j < end; j++)
				graph.get(i).add(Integer.parseInt(st.nextToken()));
		}

		numberSet.add(1);
		powerSet(2, 0);

//		print();

		for(Set<Integer> set: setList) {
			if(isConnected(set)) {
				minDif = Math.min(minDif, calcDif(set));
			}
		}
		
		if(minDif == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minDif);

	}

	public static void powerSet(int num, int depth) {

		if (depth == N - 1) {
			Set<Integer> tmp = new HashSet<>();

			for (int item : numberSet) {
				tmp.add(item);
			}

			setList.add(tmp);
			return;
		}

		numberSet.add(num);
		powerSet(num + 1, depth + 1);
		numberSet.remove(num);
		powerSet(num + 1, depth + 1);

	}

	public static boolean isConnected(Set<Integer> set) {
		boolean isFound;

		int pollItem;
		int nextItem;
		boolean[] isVisited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();

		if (set.size() == 0 || set.size() == N)
			return false;

		q.add(1);
		isVisited[1] = true;

		while (!q.isEmpty()) {
			pollItem = q.poll();

			for (int i = 0; i < graph.get(pollItem).size(); i++) {
				nextItem = graph.get(pollItem).get(i);
				if (set.contains(nextItem)) {
					if (!isVisited[nextItem]) {
						isVisited[nextItem] = true;
						q.add(nextItem);
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (!set.contains(i)) {
				q.add(i);
				isVisited[i] = true;
				break;
			}
		}

		while (!q.isEmpty()) {
			pollItem = q.poll();

			for (int i = 0; i < graph.get(pollItem).size(); i++) {
				nextItem = graph.get(pollItem).get(i);
				if (!set.contains(nextItem)) {
					if (!isVisited[nextItem]) {
						isVisited[nextItem] = true;
						q.add(nextItem);
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (!isVisited[i])
				return false;
		}

		return true;
	}

	public static int calcDif(Set<Integer> set) {
		int a = 0;
		int b = 0;

		for (int i = 1; i <= N; i++) {
			if (set.contains(i)) {
				a += people[i];
			} else {
				b += people[i];
			}
		}

		return Math.abs(a - b);
	}

	public static void print() {

		for (Set<Integer> set : setList) {
			for (int item : set) {
				System.out.print(item + " ");
			}
			System.out.println();

			System.out.println(isConnected(set));
		}
	}
}