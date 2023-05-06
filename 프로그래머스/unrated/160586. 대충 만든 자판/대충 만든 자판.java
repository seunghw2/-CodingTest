import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        char alp;
        int result;
        int[] answer = new int[targets.length];
        String target;
        
        for(String key: keymap){
            for(int i = 0; i < key.length(); i++){
                alp = key.charAt(i);
                if(map.containsKey(alp) == true){
                    if(map.get(alp) > i+1){
                        map.put(alp, i+1);
                    }
                }
                else{
                    map.put(alp, i+1);
                }
            }
        }
        
        for(int k = 0; k < targets.length; k++){
            target = targets[k];
            result = 0;
            for(int i = 0; i < target.length(); i++){
                alp = target.charAt(i);
                if(map.containsKey(alp)){
                    result += map.get(alp);
                }
                else{
                    result = -1;
                    break;
                }
            }
            answer[k] = result;
        }
        
        
        return answer;
    }
}