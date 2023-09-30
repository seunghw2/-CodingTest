import java.io.*;
import java.util.*;

public class Main {
    public static int C, R, O;
    public static int start, mid1, mid2;
    public static int[] option;
    public static List<List<Node>> graph;

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

        int T;
        int[] startDist, mid1Dist, mid2Dist;
        List<Integer> ans;

        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            graph = new ArrayList<>();
            ans = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            O = Integer.parseInt(st.nextToken());

            for(int i = 0; i < C; i++)
                graph.add(new ArrayList<>());
            option = new int[O];

            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken()) - 1;
            mid1 = Integer.parseInt(st.nextToken()) - 1;
            mid2 = Integer.parseInt(st.nextToken()) - 1;

            for(int r = 0; r < R; r++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int d = Integer.parseInt(st.nextToken());

                graph.get(a).add(new Node(b, d));
                graph.get(b).add(new Node(a, d));
            }

            for(int o = 0; o < O; o++){
                option[o] = Integer.parseInt(br.readLine()) - 1;
            }

            startDist = dijkstra(start);
            mid1Dist = dijkstra(mid1);
            mid2Dist = dijkstra(mid2);

            for(int opt: option){
                int minDist = Math.min(startDist[mid1] + mid1Dist[mid2] + mid2Dist[opt], startDist[mid2] + mid2Dist[mid1] + mid1Dist[opt]);
                if(minDist == startDist[opt])
                    ans.add(opt);
            }

            Collections.sort(ans);
            for(int item: ans)
                sb.append(item + 1).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int[] dijkstra(int num){
        int[] dist = new int[C];
        Arrays.fill(dist, 10_000_000);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.weight, o2.weight);
        });

        pq.add(new Node(num, 0));
        dist[num] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(dist[now.idx] < now.weight)
                continue;

            for(int i = 0; i < graph.get(now.idx).size(); i++){
                Node next = graph.get(now.idx).get(i);
                if(dist[next.idx] > dist[now.idx] + next.weight){
                    dist[next.idx] = dist[now.idx] + next.weight;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        return dist;
    }
}