import java.util.*;

class Solution {
    
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        int idx = -1;
        String front_player = players[0];
        String called_player = players[0];
        
        // HashMap 초기화
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        // callings 탐색
        for (String called: callings){
            idx = map.get(called);
            front_player = players[idx - 1];
            called_player = players[idx];
            // swap
            players[idx-1] = called_player;
            players[idx] = front_player;
            // map update
            map.put(front_player, idx);
            map.put(called_player, idx-1);
        }
        
        String[] answer = players;
        return answer;
    }
}