import java.io.*;
import java.util.*;

public class Main {
    public static int V, E;
    public static List<List<Node>> graph = new ArrayList<>();
    public static int MAX = 10_000;
    public static int[] dist;
    public static int[] parent;

    public static class Node{
        int idx;
        int weight;

        public Node(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for(int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        dijkstra();

//        System.out.println(Arrays.toString(dist));

        sb.append(V-1).append("\n");
        for(int i = 1; i < V; i++){
            sb.append(i+1).append(" ").append(parent[i]+1).append("\n");
        }
        System.out.println(sb);
    }

    public static void dijkstra(){
        dist = new int[V];
        parent = new int[V];
        Arrays.fill(dist, MAX);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.weight, o2.weight);
        });

        pq.add(new Node(0, 0));
        dist[0] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(dist[now.idx] < now.weight)
                continue;

            for(int i = 0; i < graph.get(now.idx).size(); i++){
                Node next = graph.get(now.idx).get(i);
                if(dist[next.idx] > dist[now.idx] + next.weight){
                    dist[next.idx] = dist[now.idx] + next.weight;
                    parent[next.idx] = now.idx;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

    }
}