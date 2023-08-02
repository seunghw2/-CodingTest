import java.io.*;
import java.util.*;

public class Main {
	public static int N, minDist;
	public static boolean[] isVisited;
	public static StringBuilder sb = new StringBuilder();
	public static Stack<String> stack;
	public static List<String> mbtis;

	public static int calcThree(String mbti1, String mbti2, String mbti3) {
		int cnt = 0;
		
		for (int i = 0; i < 4; i++) {
			if (mbti1.charAt(i) == mbti2.charAt(i) && mbti1.charAt(i) == mbti3.charAt(i))
				continue;
			else
				cnt += 2;
		}

		return cnt;
	}

	public static void dfs(int num, int depth) {
		if (depth == 3) {
			int dist = calcThree(stack.get(0), stack.get(1), stack.get(2));
			
			if(dist < minDist)
				minDist = dist;
			
			return;
		}
		
		for(int i = num; i < N; i++) {
			if(!isVisited[i]) {
				stack.add(mbtis.get(i));
				isVisited[i] = true;
				dfs(i, depth + 1);
				stack.pop();
				isVisited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String mbtiTmp = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			minDist = Integer.MAX_VALUE;
			isVisited = new boolean[N];
			mbtis = new ArrayList<>();
			stack = new Stack<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				mbtiTmp = st.nextToken();
				mbtis.add(mbtiTmp);
			}

			if(N > 32) {
				sb.append(0).append("\n");
				continue;
			}
			
			dfs(0, 0);
			
			sb.append(minDist).append("\n");
		}
		System.out.println(sb);
	}
}