import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static Queue<Integer> queue = new LinkedList<>();
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] order;
    static int cnt;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int a;
        int b;
        order = new int[N + 1];
        Arrays.fill(order, 1);

        for(int i = 0; i <= N; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
        }

        for(int i = 1; i <= N; i++){
            for(int item: adjList.get(i)) {
                order[item] = Math.max(order[item], order[i] + 1);
            }
        }

        for(int i = 1; i <= N; i++){
            System.out.print(order[i]);
            if(i != N){
                System.out.print(" ");
            }
        }
    }
}