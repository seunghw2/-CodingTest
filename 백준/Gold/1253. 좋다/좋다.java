import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        int left, right;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
        	list.add(Integer.parseInt(st.nextToken()));
        list.sort(Comparator.naturalOrder());
        
        for(int i = 0; i < N; i++) {
            left = 0;
            right = N - 1;
        	
            while(left < right) {
            	int num = list.get(i);
            	int l = list.get(left);
            	int r = list.get(right);
            	
            	if(l + r < num || left == i)
            		left += 1;
            	else if(l + r > num || right == i)
            		right -= 1;
            	else {
        			cnt += 1;
            		break;
            	}
            }
        }
        
        System.out.println(cnt);
        
    }
}