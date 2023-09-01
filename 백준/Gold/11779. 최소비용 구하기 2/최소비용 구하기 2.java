import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node{
        int idx;
        int w;

        public Node(int idx, int w) {
            this.idx = idx;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n, m;
        int start, end;
        int[] parent, dist;
        List<Integer> ansList = new ArrayList<>();
        List<List<Node>> graph = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2)->{
            return Integer.compare(n1.w, n2.w);
        });

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = Integer.MAX_VALUE;
            dist[i] = Integer.MAX_VALUE;
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        pq.add(new Node(start, 0));
        parent[start] = 0;
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > dist[now.idx])
                continue;

            for (int i = 0; i < graph.get(now.idx).size(); i++) {
                Node next = graph.get(now.idx).get(i);

                if(dist[next.idx] > now.w + next.w){
                    dist[next.idx] = now.w + next.w;
                    parent[next.idx] = now.idx;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        int idx = end;
        while(idx != 0){
            ansList.add(idx);
            idx = parent[idx];
        }

        Collections.reverse(ansList);


        sb.append(dist[end]).append("\n");
        sb.append(ansList.size()).append("\n");
        for (int item : ansList) {
            sb.append(item).append(" ");
        }

        System.out.println(sb);
    }
}