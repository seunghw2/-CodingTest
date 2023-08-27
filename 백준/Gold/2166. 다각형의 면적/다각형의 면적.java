import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        long x;
        long y;

        public Node(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N;
        long width = 0;
        Node[] nodes;

        N = Integer.parseInt(br.readLine());
        nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            nodes[i] = new Node(a, b);
        }

        for (int i = 1; i < N - 1; i++) {
            width += calcTri(nodes[0], nodes[i], nodes[i + 1]);
        }

        System.out.printf("%.1f", Math.abs((double) width / 2));
    }

    public static long calcTri(Node p1, Node p2, Node p3) {
        long w = 0;

        w += (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y);
        w -= (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);

        return w;
    }
}