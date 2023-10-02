import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer> lis = new ArrayList<>();
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            int idx = bisearch(num);

            if(idx == lis.size())
                lis.add(num);
            else
                lis.set(idx, num);
        }
        System.out.println(N - lis.size());
    }

    public static int bisearch(int num){
        int lo = 0;
        int hi = lis.size();
        int mid;

        while(lo < hi){
            mid = (lo + hi) / 2;

            if(num >= lis.get(mid))
                lo = mid + 1;
            else
                hi = mid;
        }
        return hi;
    }
}