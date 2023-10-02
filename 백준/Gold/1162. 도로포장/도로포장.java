import java.io.*;
import java.util.*;

public class Main {
    public static class Node{
        int idx;
        long weight;
        int k;

        public Node(int idx, long weight, int k){
            this.idx = idx;
            this.weight = weight;
            this.k = k;
        }

        @Override
        public String toString(){
            return "[" + idx + " / " + weight + " / " + k + "]";
        }
    }

    public static int N, M, K;
    public static final long MAX = 10_000_000_000L;
    public static long[][] dist;
    public static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        long ans = MAX;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++)
            graph.add(new ArrayList<>());

        for(int m = 0 ; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c, 0));
            graph.get(b).add(new Node(a, c, 0));
        }

        dijkstra();

        for(int i = 0; i <= K; i++){
            ans = Math.min(ans, dist[i][N-1]);
        }

        System.out.println(ans);
    }

    public static void dijkstra(){
        dist = new long[K+1][N];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->{
            return Long.compare(o1.weight, o2.weight);
        });

        for(int i = 0; i <= K; i++) {
            Arrays.fill(dist[i], MAX);
            dist[i][0] = 0;
        }
        pq.add(new Node(0, 0, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

//            System.out.println(now);
//            print();

            if(dist[now.k][now.idx] < now.weight)
                continue;

            for(int i = 0; i < graph.get(now.idx).size(); i++){
                Node next = graph.get(now.idx).get(i);

                if(now.k < K){
                    if(dist[now.k + 1][next.idx] > dist[now.k][now.idx]){
                        dist[now.k + 1][next.idx] = dist[now.k][now.idx];
                        pq.add(new Node(next.idx, dist[now.k + 1][next.idx], now.k+1));
                    }
                }

                if(dist[now.k][next.idx] > dist[now.k][now.idx] + next.weight){
                    dist[now.k][next.idx] = dist[now.k][now.idx] + next.weight;
                    pq.add(new Node(next.idx, dist[now.k][next.idx], now.k));
                }
            }
        }
    }

    public static void print(){
        for(int j = 0; j <= K; j++){
            for(int i = 0; i < N; i++){
                System.out.print(dist[j][i]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}