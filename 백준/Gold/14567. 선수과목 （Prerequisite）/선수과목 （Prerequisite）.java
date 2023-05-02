import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int a;
        int b;

        List<List<Integer>> adjList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int cnt[] = new int[N + 1];
        int order[] = new int[N + 1];
        int item;

        Arrays.fill(cnt, 0);
        Arrays.fill(order, 0);
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            cnt[b] += 1;
        }

        for (int i = 0; i <= N; i++) {
            if (cnt[i] == 0) {
                order[i] = 1;
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            item = queue.poll();
            for (int next : adjList.get(item)) {
                cnt[next] -= 1;
                if (cnt[next] == 0) {
                    order[next] = order[item] + 1;
                    queue.add(next);
                }
            }
        }

        for(int i = 1; i <= N; i++){
            System.out.print(order[i]);
            if(i != N){
                System.out.print(" ");
            }
        }
    }
}