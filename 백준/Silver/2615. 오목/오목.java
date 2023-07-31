import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] dx = { 1, 1, 1, 0 };
	public static int[] dy = { -1, 0, 1, 1 };
	public static int[] cx = { -1, -1, -1, 0 };
	public static int[] cy = { 1, 0, -1, -1 };
	public static int orix;
	public static int oriy;

	public static boolean isRange(int[][] arr, int x, int y) {
		if (x >= 0 && x < 19 && y >= 0 && y < 19)
			return true;
		return false;
	}

	public static void dfs(int[][] arr, int x, int y, int color, int dir, int depth) {
		int mx, my, mxx, myy;

		if (depth == 1) {
			mx = x + cx[dir];
			my = y + cy[dir];
			if (isRange(arr, mx, my)) {
				if (arr[my][mx] == color)
					return;
			}
		}

		mx = x + dx[dir];
		my = y + dy[dir];

		if (isRange(arr, mx, my)) {
			if (arr[my][mx] == color) {
				depth += 1;
				if (depth == 5) {
					mxx = mx + dx[dir];
					myy = my + dy[dir];
					if (isRange(arr, mxx, myy) && arr[myy][mxx] == color)
						return;
					System.out.println(color);
					System.out.println((oriy + 1) + " " + (orix + 1));
					System.exit(0);
				}
				dfs(arr, mx, my, color, dir, depth);
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] arr = new int[19][19];

		for (int j = 0; j < 19; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 19; i++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		for (int j = 0; j < 19; j++) {
			for (int i = 0; i < 19; i++) {
				for (int k = 0; k < 4; k++) {
					if (arr[j][i] != 0) {
						orix = i;
						oriy = j;
						dfs(arr, i, j, arr[j][i], k, 1);

					}
				}
			}
		}
		System.out.println(0);
	}
}