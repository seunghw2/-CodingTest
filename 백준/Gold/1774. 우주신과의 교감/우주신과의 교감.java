import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static int N, M;
    public static int[] parent;
    public static List<Point> shipList = new ArrayList<>();

    public static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->{
        return Double.compare(o1.weight, o2.weight);
    });

    public static class Node{
        int s;
        int e;
        double weight;

        public Node(int s, int e, double weight){
            this.s = s;
            this.e = e;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N];
        for(int i = 0; i < N; i++)
            parent[i] = i;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            shipList.add(new Point(a, b));
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            unionParent(a, b);
        }

        getPQ();

        System.out.printf("%.2f", (double) Math.round(getPath() * 100) / 100);
    }

    public static double getPath(){
        double tot = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(getParent(now.s) == getParent(now.e))
                continue;

            tot += now.weight;
            unionParent(now.s, now.e);
        }
        return tot;
    }

    public static void getPQ(){
        for(int j = 0; j < N - 1; j++){
            for(int i = j + 1; i < N; i++){
                pq.add(new Node(i, j, calcDist(shipList.get(i), shipList.get(j))));
            }
        }
    }

    public static double calcDist(Point p1, Point p2){
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static int getParent(int idx){
        if(parent[idx] == idx)
            return parent[idx];
        return parent[idx] = getParent(parent[idx]);
    }

    public static void unionParent(int i1, int i2){
        int p1 = getParent(i1);
        int p2 = getParent(i2);

        if(p1 > p2)
            parent[p1] = p2;
        else
            parent[p2] = p1;
    }
}