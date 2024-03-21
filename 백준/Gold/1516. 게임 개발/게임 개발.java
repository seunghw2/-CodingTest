import java.util.*;
import java.io.*;

public class Main {
    public static class Node{
        int idx;
        int time;
        
        public Node(int idx, int time){
            this.idx = idx;
            this.time = time;
        }
    }
    
    public static int N;
    public static int[] time;
    public static int[] in;
    public static int[] totTimes;
    
    public static List<List<Integer>> graph = new ArrayList<>();
    public static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
        return Integer.compare(o1.time, o2.time);
    });
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        
        time = new int[N];
        in = new int[N];
        totTimes = new int[N];
        
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            time[i] = Integer.parseInt(st.nextToken());
            
            while(true){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == -1)
                    break;
                in[i] += 1;
                graph.get(tmp - 1).add(i);
            }
        }
        
        getTotTime();
        
        for(int i : totTimes){
            sb.append(i).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static void getTotTime(){
        int totTime = 0;
        
        for(int i = 0; i < N; i++){
            if(in[i] == 0){
                pq.add(new Node(i, time[i]));
                totTimes[i] = time[i];
            }
        }
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            totTime += time[now.idx];
            
            for(int next : graph.get(now.idx)){
                in[next] -= 1;
                
                if(in[next] == 0){
                    pq.add(new Node(next, now.time + time[next]));
                    totTimes[next] = now.time + time[next];
                }
            }
        }
    }
}