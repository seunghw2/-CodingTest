import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static List<Integer> list;
    public static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T, N, K, X, Y, W;
        int totTime;
        int idx;
        int item;
        int restTime;
        int next;
        int[] edgeCnt;
        List<List<Integer>> graph;

        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            totTime = 0;
            time = new int[N+1];
            edgeCnt = new int[N+1];
            edgeCnt[0] = -1;

            list = new ArrayList<>();
            graph = new ArrayList<>();

            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                time[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                edgeCnt[b] += 1;
            }

            W = Integer.parseInt(br.readLine());

            for(int i = 1; i <= N; i++){
                if(edgeCnt[i] == 0){
                    list.add(i);
                }
            }

            while (!list.isEmpty()) {
                idx = findMin();
                item = list.get(idx);

                restTime = time[item];
                totTime += restTime;

                if(item == W)
                    break;

                for(int i = 0; i < list.size(); i++){
                    time[list.get(i)] -= restTime;
                }

                list.remove(idx);

                for(int i = 0; i < graph.get(item).size(); i++){
                    next = graph.get(item).get(i);
                    edgeCnt[next] -= 1;
                    if(edgeCnt[next] == 0){
                        list.add(next);
                    }
                }
            }
            sb.append(totTime).append("\n");
        }
        System.out.println(sb);
    }

    public static int findMin(){
        int minV = Integer.MAX_VALUE;
        int minI = 0;

        for(int i = 0; i < list.size(); i++){
            if(time[list.get(i)] < minV){
                minV = time[list.get(i)];
                minI = i;
            }
        }
        return minI;
    }
}