import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int item[];
        int list[];
        Queue<int[]> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        queue.add(new int[]{A, 0});
        while (!queue.isEmpty()){
            item = queue.poll();
            if(item[0] == K){
                System.out.println(item[1]);
                break;
            }
            list = new int[]{item[0] * 2, item[0] + 1};
//            System.out.println(Arrays.toString(list));
            for(int next: list){
                if(!set.contains(next) && next < K * 2){
                    set.add(next);
                    queue.add(new int[]{next, item[1] + 1});
                }
            }
        }
    }
}
