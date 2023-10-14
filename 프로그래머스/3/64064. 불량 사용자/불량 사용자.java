import java.util.*;

class Solution {
    public static List<List<Integer>> list = new ArrayList<>();
    public static int answer = 0;
    public static int N, M;
    public static Set<Integer> set = new HashSet<>();
    public static Set<Integer> ansSet = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        N = user_id.length;
        M = banned_id.length;
        
        for(int i = 0; i < M; i++)
            list.add(new ArrayList<>());
        
        getList(user_id, banned_id);
        
        // for(List<Integer> tmpList: list){
        //     System.out.println(tmpList);
        // }
        
        dfs(0);
        
        return ansSet.size();
    }
    
    public static void dfs(int num){
        if(num == M){
            StringBuilder sb = new StringBuilder();
            
            for(int item: set){
                sb.append(item);
            }
            
            ansSet.add(Integer.parseInt(sb.toString()));
            
            return;
        }
        for(int item: list.get(num)){
            if(!set.contains(item)){
                // System.out.print(" >> "+num);
                set.add(item);
                dfs(num+1);
                set.remove(item);
            }
        }
    }
    
    public void getList(String[] user_id, String[] banned_id) {
        for(int j = 0; j < M; j++){
            String ban = banned_id[j];
            
            for(int i = 0; i < N; i++){
                boolean suc = true;
                
                String user = user_id[i];
                
                int userSize = user.length();
                int banSize = ban.length();
                
                if(userSize != banSize)
                    continue;
                
                for(int u = 0; u < userSize; u++){
                    if(user.charAt(u) != ban.charAt(u)){
                        if(ban.charAt(u) == '*')
                            continue;
                            
                        suc = false;
                        break;
                    }
                }
                if(suc){
                    list.get(j).add(i);
                }
            }
        }
    }
}