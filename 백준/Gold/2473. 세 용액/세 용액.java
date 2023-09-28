import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static long minGap = Long.MAX_VALUE;
    public static List<Integer> list = new ArrayList<>();
    public static int[] ans = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        for(int i = 0; i < list.size() - 2; i++){
            find(i);
        }

        for(int i = 0; i < 3; i++)
            System.out.print(ans[i] + " ");
        System.out.println();
    }

    public static void find(int start){
        int target = -1 * list.get(start);
        int left = start + 1;
        int right = list.size() - 1;
        long sum;

        while(left < right){
            sum = list.get(left) + list.get(right);

            if(minGap > Math.abs(list.get(start) + sum)){
                minGap = Math.abs(list.get(start) + sum);
                ans[0] = list.get(start);
                ans[1] = list.get(left);
                ans[2] = list.get(right);
            }

            if(sum == target){
                break;
            }
            else if(sum > target){
                right -= 1;
            }
            else{
                left += 1;
            }
        }
    }
}