import java.util.*;

class Solution {
    public List<Integer> solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> results = new ArrayList<>();
        int result = 0;
        
        for(int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        for(String[] item : photo) {
            result = 0;
            
            for(String human : item) {
                if (map.containsKey(human) == true) {
                    result = result + map.get(human);
                }
                else {
                    continue;
                }
            }
            results.add(result);
        }
        
        
        // int[] answer = {};
        return results;
    }
}