import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int Visited[];
    static int order;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        int a = -1;
        int b = -1;
        Visited = new int[N+1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());;
            b = Integer.parseInt(st.nextToken());;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(graph.get(i));
        }

        order = 1;
        dfs(R);

        for(int i = 1; i <= N; i++){
            System.out.println(Visited[i]);
        }
    }

    public static void dfs(int start){
        Visited[start] = order;
        order += 1;
        for(int item: graph.get(start)){
            if (Visited[item] == 0){
                dfs(item);
            }
        }
    }
}
