import java.io.*;
import java.util.Arrays;

public class Main {
	public static char[][] stars;
	public static char[][] star = { { ' ', ' ', '*', ' ', ' ' }, { ' ', '*', ' ', '*', ' ' },
			{ '*', '*', '*', '*', '*' } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int k = Integer.parseInt(br.readLine());
		stars = new char[k][2 * k - 1];

		for (char[] items : stars)
			Arrays.fill(items, ' ');

		dfs(k, 0, 0);
		
		for (char[] items : stars) {
			for (char item : items)
				sb.append(item);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

	private static void dfs(int k, int x, int y) {
		if (k == 3) {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 5; i++) {
					stars[y + j][x + i] = star[j][i];
				}
			}

			return;
		}
		dfs(k / 2, x + k / 2, y);
		dfs(k / 2, x, y + k / 2);
		dfs(k / 2, x + k, y + k / 2);
	}
}