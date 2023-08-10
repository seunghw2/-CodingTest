import java.io.*;
import java.util.*;

public class Main {

    public static int[][] arr;
    public static int N, M, K;
    public static List<List<Integer>> list = new ArrayList<>();
    public static boolean[] isVisited;
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] ori;
        int[] r, c, s;
        int ans;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ori = new int[N][M];
        arr = new int[N][M];
        isVisited = new boolean[K];
        r = new int[K];
        c = new int[K];
        s = new int[K];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                ori[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            r[k] = Integer.parseInt(st.nextToken());
            c[k] = Integer.parseInt(st.nextToken());
            s[k] = Integer.parseInt(st.nextToken());
        }

        ans = Integer.MAX_VALUE;
        permutate(0, 0);

        for(List<Integer> permutation: list){
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    arr[y][x] = ori[y][x];
                }
            }
            for(int idx: permutation){
                Rotate(c[idx] - 2, r[idx] - 2, s[idx], 1);
            }
            ans = Math.min(ans, calc());
        }
        System.out.println(ans);
    }

    public static void permutate(int num, int depth){
        if(depth == K){
            List<Integer> tmp = new ArrayList<>();
            for(int item: stack)
                tmp.add(item);
            list.add(tmp);
            return;
        }
        for(int i = 0; i < K; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                stack.add(i);
                permutate(i, depth + 1);
                stack.pop();
                isVisited[i] = false;
            }
        }
    }

    private static void Rotate(int startx, int starty, int s, int d) {
        if (d > s) {
            return;
        }

        int lastx = startx + 2 * d;
        int lasty = starty + 2 * d;

        int tmp = arr[starty][startx];

        for (int y = starty; y < lasty; y++)
            arr[y][startx] = arr[y + 1][startx];

        for (int x = startx; x < lastx; x++)
            arr[lasty][x] = arr[lasty][x + 1];

        for (int y = lasty; y > starty; y--)
            arr[y][lastx] = arr[y-1][lastx];

        for (int x = lastx; x > startx; x--)
            arr[starty][x] = arr[starty][x - 1];

        arr[starty][startx+1] = tmp;

        Rotate(startx - 1, starty - 1, s, d + 1);
    }

    private static int calc() {
        int min = Integer.MAX_VALUE;
        int sum;

        for(int y = 0; y < N; y++){
            sum = 0;
            for(int x = 0; x < M; x++){
                sum += arr[y][x];
            }
            min = Math.min(min, sum);
        }

        return min;
    }
}