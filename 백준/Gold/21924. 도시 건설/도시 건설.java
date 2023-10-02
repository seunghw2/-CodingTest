import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static double tot;
    public static List<List<Node>> graph = new ArrayList<>();

    public static class Node{
        int idx;
        double weight;

        public Node(int idx, double weight){
            this.idx = idx;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            double c = Double.parseDouble(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));

            tot += c;
        }

        System.out.printf("%.0f", prim());
    }

    public static double prim(){
        double ret = 0;
        boolean[] isVisited = new boolean[N];

        PriorityQueue<Node> pq= new PriorityQueue<>((o1, o2)->{
            return Double.compare(o1.weight, o2.weight);
        });

        pq.add(new Node(0, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(!isVisited[now.idx]){
                isVisited[now.idx] = true;
                ret += now.weight;
            }

            for(int i = 0; i < graph.get(now.idx).size(); i++){
                Node next = graph.get(now.idx).get(i);

                if(!isVisited[next.idx]){
                    pq.add(new Node(next.idx, next.weight));
                }
            }
        }

        for(boolean item: isVisited){
            if(!item)
                return -1;
        }

        return tot - ret;
    }
}