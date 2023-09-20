import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static class Node {
		int x;
		int t;

		public Node(int x, int t) {
			this.x = x;
			this.t = t;
		}
	}

	public static int[] cnt = new int[200001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		int N, K;
		int targetTime = Integer.MAX_VALUE;
		int ans = 0;
		Arrays.fill(cnt, Integer.MAX_VALUE);
		Queue<Node> q = new LinkedList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		q.add(new Node(N, 0));

		while (!q.isEmpty()) {
			Node now = q.poll();

			if (now.t > targetTime)
				break;

			if (now.x == K && now.t <= targetTime) {
				targetTime = now.t;
				ans += 1;
				continue;
			}

			if (now.t < targetTime) {
				if(isRange(now.x - 1) && cnt[now.x - 1] >= now.t + 1) {
					cnt[now.x - 1] = now.t + 1;
					q.add(new Node(now.x - 1, now.t + 1));
				}
				if(isRange(now.x + 1) && cnt[now.x + 1] >= now.t + 1) {
					cnt[now.x + 1] = now.t + 1;
					q.add(new Node(now.x + 1, now.t + 1));
				}
				if(isRange(now.x * 2) && cnt[now.x * 2] >= now.t + 1) {
					cnt[now.x * 2] = now.t + 1;
					q.add(new Node(now.x * 2, now.t + 1));
				}
			}
		}
		
		System.out.println(targetTime);
		System.out.println(ans);
	}
	
	public static boolean isRange(int x) {
		return (x >= 0 && x <= 200000);
	}
}