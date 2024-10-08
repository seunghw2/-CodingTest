class Solution {
    public int N;
    
    public int solution(int[] diffs, int[] times, long limit) {
        
        N = diffs.length;
        
        int lo = 1;
        int hi = 100000;
        
        while(lo < hi){
            int mid = (lo + hi) / 2;
            
            if(checkTime(mid, diffs, times, limit) == 1){
                lo = mid + 1;
            }
            else{
                hi = mid;
            }
        }
        
        return lo;
    }
    
    int checkTime(int level, int[] diffs, int[] times, long limit){
        long tot = 0;
        
        for(int i = 0; i < N; i++){
            if(diffs[i] <= level){
                tot += times[i];
            }
            else{
                tot += ((times[i] + times[i-1]) * (diffs[i] - level) + times[i]);
            }
        }
        
        // System.out.println(level + " : " + tot);
        
        if(tot > limit)
            return 1;
        else
            return 0;
    }
}