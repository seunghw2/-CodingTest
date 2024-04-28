class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] ans = new int[queries.length];
        
        int[][] arr = new int[rows][columns];
        int cnt = 1;
        for(int y = 0; y < rows; y++){
            for(int x = 0; x < columns; x++){
                arr[y][x] = cnt++;
            }
        }
        
        for(int i = 0; i < queries.length; i++){
            int y1 = queries[i][0] - 1;
            int x1 = queries[i][1] - 1;
            int y2 = queries[i][2] - 1;
            int x2 = queries[i][3] - 1;
            
            int tmp = arr[y1][x1];
            ans[i] = tmp;
            
            for(int y = y1; y < y2; y++){
                arr[y][x1] = arr[y+1][x1];
                ans[i] = Math.min(ans[i], arr[y][x1]);
            }
            for(int x = x1; x < x2; x++){
                arr[y2][x] = arr[y2][x+1];
                ans[i] = Math.min(ans[i], arr[y2][x]);
            }
            for(int y = y2; y > y1; y--){
                arr[y][x2] = arr[y-1][x2];
                ans[i] = Math.min(ans[i], arr[y][x2]);
            }
            for(int x = x2; x > x1; x--){
                arr[y1][x] = arr[y1][x-1];
                ans[i] = Math.min(ans[i], arr[y1][x]);
            }
            arr[y1][x1+1] = tmp;
        }
        
        return ans;
    }
}