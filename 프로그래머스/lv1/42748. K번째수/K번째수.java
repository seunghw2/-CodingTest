import java.util.*;
// System.out.println(Arrays.toString(brr));

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int i, j, k;
        Integer[] brr;
        int[] command;
        int[] answer = new int[commands.length];
        
        for(int y = 0; y < commands.length; y++){
            command = commands[y];
            
            i = command[0];
            j = command[1];
            k = command[2];
            
            brr = new Integer[j-i+1];
            for(int x = i-1; x < j; x++){
                brr[x-i+1] = array[x];
            }
            Arrays.sort(brr, (o1, o2)->(o1-o2));
            answer[y] = brr[k-1];
        }
        
        return answer;
    }
}