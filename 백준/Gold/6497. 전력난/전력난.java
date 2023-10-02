import java.io.*;
import java.util.*;

public class Main {
    public static int V, E;
    public static int[] parent;
    public static PriorityQueue<Node> pq;

    public static class Node{
        int s;
        int e;
        int weight;

        public Node(int s, int e, int weight){
            this.s = s;
            this.e = e;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();

        while(true){
            int max = 0;
            pq = new PriorityQueue<>((o1, o2) -> {
                return Integer.compare(o1.weight, o2.weight);
            });

            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            if(V == 0 && E == 0)
                break;

            for(int e = 0; e < E; e++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                pq.add(new Node(a, b, c));
                max += c;
            }
            sb.append(max - kruskal()).append("\n");
        }
        System.out.println(sb);
    }

    public static int kruskal(){
        int tot = 0;
        parent = new int[V];

        for(int i = 0; i < V; i++)
            parent[i] = i;

        for(int cnt = 0; cnt < V - 1;){
            Node now = pq.poll();

            if(getParent(now.s) == getParent(now.e))
                continue;

            unionParent(now.s, now.e);
            tot += now.weight;
            cnt += 1;
        }

        return tot;
    }

    public static int getParent(int idx){
        if(idx == parent[idx])
            return idx;
        return parent[idx] = getParent(parent[idx]);
    }

    public static void unionParent(int i1, int i2){
        int p1 = getParent(i1);
        int p2 = getParent(i2);

        if(p1 < p2)
            parent[p2] = p1;
        else
            parent[p1] = p2;
    }
}