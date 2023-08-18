import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int ans = 0;
		List<Character> words = new ArrayList<>();

		String s1 = " " + br.readLine();
		String s2 = " " + br.readLine();
		

		int[][] dp = new int[s2.length()][s1.length()];

		for (int y = 1; y < s2.length(); y++) {
			for (int x = 1; x < s1.length(); x++) {
				if (s1.charAt(x) == s2.charAt(y)) {
					dp[y][x] = dp[y - 1][x - 1] + 1;
				} else {
					dp[y][x] = Math.max(dp[y][x - 1], dp[y - 1][x]);
				}
			}
		}
		
		ans = dp[s2.length() - 1][s1.length()-1];

//		if (ans == 0) {
//			System.out.println(ans);
//		} else {
//			int x = s1.length() - 1;
//			int y = s2.length() - 1;
//
//			while (dp[y][x] != 0) {
//				if (dp[y][x] == dp[y][x - 1]) {
//					x -= 1;
//				} else if (dp[y][x] == dp[y - 1][x]) {
//					y -= 1;
//				} else {
//					words.add(s1.charAt(x));
//					x -= 1;
//					y -= 1;
//				}
//			}

			System.out.println(ans);
//			for (int i = words.size() - 1; i >= 0; i--)
//				sb.append(words.get(i));
//			System.out.println(sb);
//		}
	}
	
}