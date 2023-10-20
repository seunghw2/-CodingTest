import java.util.*;

class Node{
    int s;
    int e;
    int w;
    
    public Node(int s, int e, int w){
        this.s = s;
        this.e = e;
        this.w = w;
    }
}

class Solution {
    public int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
           return Integer.compare(o1.w, o2.w); 
        });
        
        for(int[] cost: costs){
            pq.add(new Node(cost[0], cost[1], cost[2]));
        }
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(getParent(now.s) == getParent(now.e)){
                continue;
            }
            else{
                answer += now.w;
                unionParent(now.s, now.e);
            }
        }
        
        return answer;
    }
    
    public int getParent(int idx){
        if(parent[idx] == idx)
            return idx;
        return parent[idx] = getParent(parent[idx]);
    }
    
    public void unionParent(int i1, int i2){
        int p1 = getParent(i1);
        int p2 = getParent(i2);
        
        if(p1 < p2)
            parent[p2] = p1;
        else
            parent[p1] = p2;
    }
}