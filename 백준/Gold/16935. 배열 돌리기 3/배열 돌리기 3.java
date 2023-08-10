import java.io.*;
import java.util.*;

public class Main {
	public static int[][] arr;
	public static int N, M;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		Map<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		int R;

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= 6; i++) {
			map.put(i, 0);
		}

		st = new StringTokenizer(br.readLine());
		int num, cnt;
		for (int r = 0; r < R; r++) {
			num = Integer.parseInt(st.nextToken());
//			cnt = map.get(num);
			calcNum(num);
//			map.put(num, cnt + 1);
		}

//		calcOne(map.get(1));
//		calcTwo(map.get(2));
//		calcThree(map.get(3));
//		calcFour(map.get(4));
//		calcFive(map.get(5));
//		calcSix(map.get(6));
		
		for(int[] items: arr) {
			for(int item: items) {
				sb.append(item).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void calcNum(int n) {
		if(n == 1)
			calcOne(1);
		else if(n == 2)
			calcTwo(1);
		else if(n == 3)
			calcThree(1);
		else if(n == 4)
			calcFour(1);
		else if(n == 5)
			calcFive(1);
		else if(n == 6)
			calcSix(1);
	}

	private static void calcOne(int T) {
		int tmp;
		for (int t = 0; t < T; t++) {
			for (int y = 0; y < N / 2; y++) {
				for (int x = 0; x < M; x++) {
					tmp = arr[y][x];
					arr[y][x] = arr[N - y - 1][x];
					arr[N - y - 1][x] = tmp;
				}
			}
		}
	}

	private static void calcTwo(int T) {
		int tmp;
		for (int t = 0; t < T; t++) {
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M / 2; x++) {
					tmp = arr[y][x];
					arr[y][x] = arr[y][M - x - 1];
					arr[y][M - x - 1] = tmp;
				}
			}
		}
	}

	private static void calcThree(int T) {
		List<Queue<Integer>> list = new ArrayList<>();
		int tmp;
		
		for (int t = 0; t < T; t++) {
			for (int y = 0; y < N; y++) {
				list.add(new LinkedList<>());
				for (int x = 0; x < M; x++) {
					list.get(y).add(arr[y][x]);
				}
			}
			arr = new int[M][N];
			for (int y = 0; y < M; y++) {
				for (int x = 0; x < N; x++) {
					arr[y][x] = list.get(N - x - 1).poll();
				}
			}
			
			tmp = N;
			N = M;
			M = tmp;
			
		}
	}

	private static void calcFour(int T) {
		List<Queue<Integer>> list = new ArrayList<>();
		int tmp;
		
		for (int t = 0; t < T; t++) {
			for (int y = 0; y < N; y++) {
				list.add(new LinkedList<>());
				for (int x = M - 1; x >= 0; x--) {
					list.get(y).add(arr[y][x]);
				}
			}
			arr = new int[M][N];
			for (int y = 0; y < M; y++) {
				for (int x = 0; x < N; x++) {
					arr[y][x] = list.get(x).poll();
				}
			}
			
			tmp = N;
			N = M;
			M = tmp;
		}
	}

	private static void calcFive(int T) {
		for (int t = 0; t < T; t++) {
			for (int y = 0; y < N / 2; y++) {
				for (int x = 0; x < M / 2; x++) {
					int tmp = arr[y][x];
					arr[y][x] = arr[y + N / 2][x];
					arr[y + N / 2][x] = tmp;
				}
			}

			for (int y = N / 2; y < N; y++) {
				for (int x = 0; x < M / 2; x++) {
					int tmp = arr[y][x];
					arr[y][x] = arr[y][x + M / 2];
					arr[y][x + M / 2] = tmp;
				}
			}

			for (int y = 0; y < N / 2; y++) {
				for (int x = M / 2; x < M; x++) {
					int tmp = arr[y][x];
					arr[y][x] = arr[y + N / 2][x];
					arr[y + N / 2][x] = tmp;
				}
			}
		}
	}

	private static void calcSix(int T) {
		for (int t = 0; t < T; t++) {
			for (int y = 0; y < N / 2; y++) {
				for (int x = 0; x < M / 2; x++) {
					int tmp = arr[y][x];
					arr[y][x] = arr[y + N / 2][x];
					arr[y + N / 2][x] = tmp;
				}
			}

			for (int y = 0; y < N / 2; y++) {
				for (int x = 0; x < M / 2; x++) {
					int tmp = arr[y][x];
					arr[y][x] = arr[y][x + M / 2];
					arr[y][x + M / 2] = tmp;
				}
			}

			for (int y = 0; y < N / 2; y++) {
				for (int x = M / 2; x < M; x++) {
					int tmp = arr[y][x];
					arr[y][x] = arr[y + N / 2][x];
					arr[y + N / 2][x] = tmp;
				}
			}
		}
	}
}