import java.util.*;
// System.out.println();

class Solution {
    String[] tmp = new String[2];
    String dir = "E";
    int dist = 0;
    int h = 0;
    int w = 0;
    boolean suc = true;
    
    public boolean isPossible(String[] park, int h, int w){
        if(h >= 0 && h < park.length && w >= 0 && w < park[0].length()){            
            if(park[h].charAt(w) != 'X'){
                return true;
            }
        }
        return false;
    }
    
    public int[] solution(String[] park, String[] routes) {
        // 처음 위치 찾기
        
        for(int j = 0; j < park.length; j++){
            for(int i = 0; i < park[0].length(); i++){
                if(park[j].charAt(i) == 'S'){
                    h = j;
                    w = i;
                }
            }
        }
        
        for(String route: routes){
            tmp = route.split(" ");
            dir = tmp[0];
            dist = Integer.parseInt(tmp[1]);
            suc = true;

            // command
            if(dir.equals("E")){
                for(int i = 1; i <= dist; i++){
                    if(!isPossible(park, h, w+i)){
                        suc = false;   
                        break;
                    }
                }
                if(suc){
                    w = w + dist;
                }
            }   
            else if(dir.equals("W")){
                for(int i = 1; i <= dist; i++){
                    if(!isPossible(park, h, w-i)){
                        suc = false;  
                        break;
                    }
                }
                if(suc){
                    w = w - dist;
                }
            }   
            else if(dir.equals("S")){
                for(int i = 1; i <= dist; i++){
                    if(!isPossible(park, h+i, w)){
                        suc = false;   
                        break;
                    }
                }
                if(suc){
                    h = h + dist;
                }
            }   
            else if(dir.equals("N")){
                for(int i = 1; i <= dist; i++){
                    if(!isPossible(park, h-i, w)){
                        suc = false; 
                        break;
                    }
                }
                if(suc){
                    h = h - dist;
                }
            }   
        }
        
        int[] answer = {h,w};
        return answer;
    }
}