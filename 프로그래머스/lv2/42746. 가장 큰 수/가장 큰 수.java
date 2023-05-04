import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            arr[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(arr, (a, b)->{
            return Integer.valueOf(b+a) - Integer.valueOf(a+b);
        });
        
        String answer = "";
        
        for(int i = 0; i < numbers.length; i++){
            answer = answer + arr[i];
        }
        
        boolean zero = true;
        for(int i = 0; i < answer.length(); i++){
            if (answer.charAt(i) != '0'){
                zero = false;
            }
        }
        
        if (zero == true){
            return "0";
        }
        else{
            return answer;
        }
        
    }
    
    
}