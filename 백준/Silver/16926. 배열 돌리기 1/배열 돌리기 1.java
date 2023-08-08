import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static int depth;
	public static int N, M, R;

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		depth = (Math.min(N, M) + 1) / 2;

		arr = new int[N][M];

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < R; r++)
			Rotate(0);

		for (int[] items : arr) {
			for (int item : items) {
				sb.append(item).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void Rotate(int d) {
		if (d == depth)
			return;

		int startx = d;
		int starty = d;
		int lastx = M - d - 1;
		int lasty = N - d - 1;

//		System.out.println(startx);
//		System.out.println(starty);
//		System.out.println(lastx);
//		System.out.println(lasty);

		int tmp = arr[starty][startx];

		for (int x = startx; x < lastx; x++)
			arr[starty][x] = arr[starty][x + 1];

		for (int y = starty; y < lasty; y++)
			arr[y][lastx] = arr[y + 1][lastx];

		for (int x = lastx; x > startx; x--)
			arr[lasty][x] = arr[lasty][x - 1];

		for (int y = lasty; y > starty; y--)
			arr[y][startx] = arr[y - 1][startx];

		if (starty != lasty)
			arr[starty + 1][startx] = tmp;
		else if (startx != lastx)
			arr[starty][startx + 1] = tmp;

		Rotate(d + 1);

	}
}