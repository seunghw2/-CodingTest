import java.util.*;

class Solution {
    public List<List<Integer>> graph = new ArrayList<>();
    public List<List<Integer>> graph2 = new ArrayList<>();
    public List<Integer> nList = new ArrayList<>();
    
    public boolean[] isVisited;
    public int cntN, cntE;
    
    public int[] solution(int[][] edges) {
        final int MAX = 1_000_000;
        int[] answer = new int[4];
        int[] in = new int[MAX + 1];
        int add = -1;
        isVisited = new boolean[MAX + 1];
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i <= MAX; i++){
            graph.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }
            
        for(int[] edge: edges){
            int s = edge[0];
            int e = edge[1];
            
            graph.get(s).add(e);
            
            graph2.get(s).add(e);
            graph2.get(e).add(s);
            
            set.add(s);
            set.add(e);
            
            in[e] += 1;
        }
        
        for(int i = 1; i <= MAX; i++){
            if(in[i] == 0){
                if(graph.get(i).size() >= 2){
                    add = i;
                    answer[0] = i;
                    isVisited[i] = true;
                    break;
                }
            }
        }
        
        for(int i = 1; i <= MAX; i++){
            if(!set.contains(i))
                continue;
            if(isVisited[i])
                continue;
            
            isVisited[i] = true;
            nList.clear();

            dfs(i);

            cntN = nList.size();
            cntE = 0;
            
            for(int n : nList){
                cntE += graph.get(n).size();
            }
            
            // System.out.println(i + " " + cntN + " " + cntE);

            if(cntE == cntN)
                answer[1] += 1;
            else if(cntE == cntN - 1)
                answer[2] += 1;
            else if(cntE == cntN + 1)
                answer[3] += 1;
        }
        
        return answer;
    }
    
    public void dfs(int start){
        nList.add(start);
        
        for(int next: graph2.get(start)){
            if(!isVisited[next]){
                isVisited[next] = true;
                dfs(next);
            }
        }
    }
}