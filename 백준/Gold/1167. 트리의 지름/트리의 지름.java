import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static int V;
    public static int ans;
    public static int idx;
    public static boolean[] isVisited;
    public static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        V = Integer.parseInt(br.readLine());

        isVisited = new boolean[V + 1];
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            while (true) {
                int b = Integer.parseInt(st.nextToken());

                if (b == -1)
                    break;

                int c = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Node(b, c));
            }
        }

        dfs(1, 0);

        isVisited = new boolean[V+1];
        dfs(idx, 0);
        System.out.println(ans);

//        print();
    }

    public static void dfs(int num, int sum) {
        if (ans < sum) {
            ans = sum;
            idx = num;
        }

        isVisited[num] = true;

        for (Node item : graph.get(num)) {
            if (!isVisited[item.idx]) {
                dfs(item.idx, sum + item.cost);
            }
        }
    }

    public static void print() {
        for (int i = 1; i <= V; i++) {
            for (Node node : graph.get(i)) {
                System.out.print(node.idx + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}