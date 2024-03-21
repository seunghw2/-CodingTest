import java.util.*;
import java.io.*;

public class Main {
    public static class Node{
        int idx;
        long weight;
        
        public Node(int idx, long weight){
            this.idx = idx;
            this.weight = weight;
        }
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N;
        long tot = 0;
        int cnt = 0;
        int[][] graph;
        boolean[] isVisited;
        
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        isVisited = new boolean[N];
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());    
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return Long.compare(o1.weight, o2.weight);
        });
        
        pq.add(new Node(0, 0));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(isVisited[now.idx])
                continue;
                
            isVisited[now.idx] = true;
            
            tot += now.weight;
            cnt += 1;
            
            if(cnt == N)
                break;
            
            for(int i = 0; i < N; i++){
                if(!isVisited[i]){
                    pq.add(new Node(i, graph[now.idx][i]));
                }   
            }
        }
        
        System.out.println(tot);
    }
}