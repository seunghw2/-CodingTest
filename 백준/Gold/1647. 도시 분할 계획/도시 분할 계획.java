import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N, M;
        int a, b, c;
        int tot = 0;
        int max = 0;
        int[] pollItem, nextItem;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[2], o2[2]);
        });

//        List<List<Integer>> graph = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            pq.add(new int[]{a, b, c});
        }

        while (!pq.isEmpty()) {
            pollItem = pq.poll();

            a = pollItem[0];
            b = pollItem[1];
            c = pollItem[2];

            if(getParent(a) != getParent(b)){
                unionParent(a, b);
                tot += c;
                max = Math.max(max, c);
            }
        }
        System.out.println(tot-max);
    }

    public static int getParent(int num){
        if(parent[num] == num)
            return num;
        return parent[num] = getParent(parent[num]);
    }

    public static void unionParent(int x1, int x2) {
        int p1 = getParent(x1);
        int p2 = getParent(x2);

        if(p1 < p2)
            parent[p2] = p1;
        else
            parent[p1] = p2;
    }
}