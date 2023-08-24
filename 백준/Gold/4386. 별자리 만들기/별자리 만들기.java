import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int[] parent;
    public static double[] starx;
    public static double[] stary;
    public static PriorityQueue<double[]> pq;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        double tot = 0;
        double[] pollItem, nextItem;

        pq = new PriorityQueue<>((o1, o2) -> {
            return Double.compare(o1[2], o2[2]);
        });

        N = Integer.parseInt(br.readLine());

        parent = new int[N];
        starx = new double[N];
        stary = new double[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            starx[i] = a;
            stary[i] = b;
        }

        pqInit();

        while (!pq.isEmpty()) {
            pollItem = pq.poll();

            int a = (int) pollItem[0];
            int b = (int) pollItem[1];
            double c = pollItem[2];

            if (getParent(a) != getParent(b)) {
                unionParent(a, b);
                tot += c;
            }
        }
        System.out.println(tot);
    }

    public static void pqInit() {
        for (int a = 0; a < N - 1; a++) {
            for (int b = a + 1; b < N; b++) {
                double tmpx = Math.pow((starx[a] - starx[b]), 2);
                double tmpy = Math.pow((stary[a] - stary[b]), 2);
                double c = Math.sqrt(tmpx + tmpy);

                pq.add(new double[]{(double) a, (double) b, c});
            }
        }
    }

    public static int getParent(int num) {
        if (parent[num] == num)
            return num;
        return parent[num] = getParent(parent[num]);
    }

    public static void unionParent(int x1, int x2) {
        int p1 = getParent(x1);
        int p2 = getParent(x2);

        if (p1 < p2)
            parent[p2] = p1;
        else
            parent[p1] = p2;
    }
}