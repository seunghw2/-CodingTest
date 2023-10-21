import java.util.*;

class Node{
    int idx;
    int w;
    
    public Node(int idx, int w){
        this.idx = idx;
        this.w = w;
    }
}

class Solution {
    public int N;
    public int[][] road;
    public int K;
    public int[] dist;
    public List<List<Node>> graph = new ArrayList<>();
    
    public int solution(int N, int[][] road, int K) {
        this.N = N;
        this.road = road;
        this.K = K;
        
        int ans = 0;
        
        dist = new int[N];
        Arrays.fill(dist, 1_000_000);
        
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] item: road){
            int s = item[0] - 1;
            int e = item[1] - 1;
            int w = item[2];
            
            graph.get(s).add(new Node(e, w));
            graph.get(e).add(new Node(s, w));
        }
        
        int answer = 0;
        
        dijkstra(N, road, K);
        
        for(int i = 0; i < N; i++){
            if(dist[i] <= K){
                ans += 1;
            }
        }

        return ans;
    }
    
    public void dijkstra(int N, int[][] road, int K){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
           return Integer.compare(o1.w, o2.w); 
        });
        
        pq.add(new Node(0, 0));
        dist[0] = 0;
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(dist[now.idx] < now.w){
                continue;
            }
            
            for(int i = 0; i < graph.get(now.idx).size(); i++){
                Node next = graph.get(now.idx).get(i);
                if(dist[next.idx] > dist[now.idx] + next.w){
                    dist[next.idx] = dist[now.idx] + next.w;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }
}