import java.io.*;

public class Main {
	public static boolean[][] video;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		int N;

		N = Integer.parseInt(br.readLine());
		video = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				if (line.charAt(j) == '1')
					video[i][j] = true;
			}
		}
		zip(0, 0, N);
		System.out.println(sb);
	}

	public static void zip(int x, int y, int N) {
		boolean first = video[y][x];
		boolean same = true;

		outerloop: for (int j = y; j < y + N; j++) {
			for (int i = x; i < x + N; i++) {
				if (video[j][i] != first) {
					same = false;
					break outerloop;
				}
			}
		}

		if (same) {
			sb.append(first ? 1 : 0);
		}
		else {
			sb.append('(');
			zip(x, y, N / 2);
			zip(x + N / 2, y, N / 2);
			zip(x, y + N / 2, N / 2);
			zip(x + N / 2, y + N / 2, N / 2);
			sb.append(')');
		}
	}

//	private static void print() {
//		for (boolean[] items : video) {
//			for (boolean item : items) {
//				System.out.print(item ? 1 : 0);
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}