import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        List<List<int[]>> list = new ArrayList<>();
        
        for(int i = 0; i < routes.length; i++){
            list.add(new ArrayList<>());    
        }
        
        for(int i = 0; i < routes.length; i++){
            int[] route = routes[i];
            
            for(int k = 0; k < routes[i].length - 1; k++){
                int[] start = points[route[k] - 1];
                int[] end = points[route[k + 1] - 1];
                    
                if(start[0] > end[0]){
                    for(int j = start[0]; j >= end[0]; j--){
                        if(list.get(i).size() >= 1 && Arrays.equals(list.get(i).get(list.get(i).size() - 1), new int[]{start[1], j}))
                            continue;
                        list.get(i).add(new int[]{start[1], j});
                    }
                }
                else if(start[0] < end[0]){
                    for(int j = start[0]; j <= end[0]; j++){
                        if(list.get(i).size() >= 1 && Arrays.equals(list.get(i).get(list.get(i).size() - 1), new int[]{start[1], j}))
                            continue;
                        list.get(i).add(new int[]{start[1], j});
                    }
                }

                if(start[1] > end[1]){
                    for(int j = start[1]; j >= end[1]; j--){
                        if(list.get(i).size() >= 1 && Arrays.equals(list.get(i).get(list.get(i).size() - 1), new int[]{j, end[0]}))
                            continue;
                        list.get(i).add(new int[]{j, end[0]});
                    }
                }
                else if(start[1] < end[1]){
                    for(int j = start[1]; j <= end[1]; j++){
                        if(list.get(i).size() >= 1 && Arrays.equals(list.get(i).get(list.get(i).size() - 1), new int[]{j, end[0]}))
                            continue;
                        list.get(i).add(new int[]{j, end[0]});
                    }
                }
            }
        }

        // for(int i = 0; i < routes.length; i++){
        //     System.out.print(i + " >> ");
        //     for(int[] item : list.get(i)){
        //         System.out.print(Arrays.toString(item));
        //     }
        //     System.out.println();
        // }
        
        int max = 0;
        for(int i = 0; i < routes.length; i++){
            max = Math.max(max, list.get(i).size());
        }
        
        for(int i = 0; i < max; i++){
            Set<Integer> set = new HashSet<>();
            Set<Integer> cntSet = new HashSet<>();
            
            for(int j = 0; j < routes.length; j++){
                if(list.get(j).size() <= i)
                    continue;

                int x = list.get(j).get(i)[0];
                int y = list.get(j).get(i)[1];
                int num = y * 101 + x;
                if(set.contains(num)){
                    cntSet.add(num);
                }
                else{
                    set.add(num);
                }
            }
            answer += cntSet.size();
        }
        return answer;
    }
}