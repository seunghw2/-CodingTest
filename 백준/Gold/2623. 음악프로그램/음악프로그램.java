import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[] cnt;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static List<Integer> order = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cnt = new int[N];
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()) - 1;
            for(int t = 1; t < tmp; t++){
                int b = Integer.parseInt(st.nextToken()) - 1;

                graph.get(a).add(b);
                cnt[b] += 1;
                a = b;
            }
        }

        tps();

        if(order.size() != N)
            System.out.println(0);
        else{
            for(int item: order){
                System.out.println(item);
            }
        }

    }

    public static void tps(){
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < N; i++){
            if(cnt[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();
            order.add(now+1);
            for(int i = 0; i < graph.get(now).size(); i++){
                int next = graph.get(now).get(i);
                cnt[next] -= 1;
                if(cnt[next] == 0)
                    q.add(next);
            }
        }
    }
}