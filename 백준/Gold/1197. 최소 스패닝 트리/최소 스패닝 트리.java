import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V, E;
        int a, b, w;
        int tot = 0;
        int[] pollItem;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];

        for(int i = 1; i <= V; i++){
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            pq.add(new int[]{a, b, w});
        }

        while (!pq.isEmpty()) {
            pollItem = pq.poll();

            a = pollItem[0];
            b = pollItem[1];
            w = pollItem[2];

//            System.out.println(parent[a] + " " + parent[b]);

            if (getParent(a) != getParent(b)) {
                unionParent(a, b);
                tot += w;
            }
        }
        System.out.println(tot);
    }
    public static int getParent(int x){
        if(parent[x] == x){
            return x;
        }
        else {
            return getParent(parent[x]);
        }
    }

    public static void unionParent(int x1, int x2) {
        int p1 = getParent(x1);
        int p2 = getParent(x2);

        if(p1 > p2)
            parent[p1] = p2;
        else
            parent[p2] = p1;
    }
}