import java.util.*;

class Solution {
    public static class Date{
        int year;
        int month;
        int day;
        
        public Date(int year, int month, int day){
            this.year = year;
            this.month = month;
            this.day =day;
        }
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int year, month, day;
        List<Integer> list = new ArrayList<>();
        
        Date todayDate = getDate(today);
        todayDate.day += 1;
        convertDate(todayDate);

        Map<Character, Integer> map = new HashMap<>();
        for(String term: terms){
            String[] tmp1 = term.split(" ");
            char tmp2 = tmp1[0].charAt(0);
            int tmp3 = Integer.parseInt(tmp1[1]);
            map.put(tmp2, tmp3);
        }
        
        for(int idx = 0; idx < privacies.length; idx++){
            String privacy = privacies[idx];
            String[] input = privacy.split(" ");

            Date newDate = getDate(input[0]);
            newDate.month += map.get(input[1].charAt(0));
            convertDate(newDate);
            
            if(newDate.year < todayDate.year)
                list.add(idx + 1);
            else if(newDate.year == todayDate.year){
                if(newDate.month < todayDate.month)
                    list.add(idx + 1);
                else if(newDate.month == todayDate.month){
                    if(newDate.day < todayDate.day)
                        list.add(idx + 1);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
    
    public static Date getDate(String date){
        int year, month, day;
        
        String[] input = date.split("\\.");
        
        year = Integer.parseInt(input[0]);
        month = Integer.parseInt(input[1]);
        day = Integer.parseInt(input[2]);
        
        return new Date(year, month, day);
    }
    
    public static void convertDate(Date date){
        if(date.day > 28){
            date.day = 1;
            date.month += 1;
        }
        
        if(date.month > 12){
            int up = (date.month - 1) / 12;
            date.month -= up * 12;
            date.year += up;
        }
    }
}