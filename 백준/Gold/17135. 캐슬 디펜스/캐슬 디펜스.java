import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M, D;

    public static int[] dx = {-1, 0, 1};
    public static int[] dy = {0, -1, 0};

    public static Set<Integer> set;
    public static boolean[][] map;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int ans = 0;
        int max = 0;
        boolean[][] ori;

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        ori = new boolean[N + 1][M];
        map = new boolean[N + 1][M];

        for (int j = 0; j < N; j++) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                if (Integer.parseInt(st.nextToken()) == 1)
                    ori[j][i] = true;
            }
        }

        for (int x1 = 0; x1 < M - 2; x1++) {
            for (int x2 = x1 + 1; x2 < M - 1; x2++) {
                for (int x3 = x2 + 1; x3 < M; x3++) {
//                    System.out.println(x1 + " " + x2 + " " + x3);
                    ans = 0;

                    for(int j = 0; j < N+1; j++){
                        for(int i = 0; i < M; i++){
                            map[j][i] = ori[j][i];
                        }
                    }

                    for (int y = N; y > 0; y--) {
                        set = new HashSet<>();

                        attack(x1, y);
                        attack(x2, y);
                        attack(x3, y);

                        for (int i : set) {
                            ans += 1;
                            map[i / M][i % M] = false;
                        }
//                        print();
                    }
                    max = Math.max(max, ans);
//                    System.out.println(ans);
                }
            }
        }
        System.out.println(max);
    }

    public static void attack(int x, int y) {
        int mx, my;
        int[] popItem;
        boolean[][] isVisited = new boolean[N + 1][M];

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y-1, 1});

        while (!q.isEmpty()) {
            popItem = q.poll();

            if (map[popItem[1]][popItem[0]]) {
                set.add(popItem[1] * M + popItem[0]);
                break;
            }

            if (popItem[2] == D)
                continue;

            for (int i = 0; i < 3; i++) {
                mx = popItem[0] + dx[i];
                my = popItem[1] + dy[i];
                if (isRange(mx, my) && !isVisited[my][mx]) {
                    isVisited[my][mx] = true;
                    q.add(new int[]{mx, my, popItem[2] + 1});
                }
            }
        }
    }

    public static boolean isRange(int x, int y) {
        return (x >= 0 && x < M && y >= 0 && y <= N);
    }

    public static void print() {
        for (boolean[] line : map) {
            for (boolean item : line) {
                System.out.print(item ? 1 : 0);
            }
            System.out.println();
        }
        System.out.println();
    }
}