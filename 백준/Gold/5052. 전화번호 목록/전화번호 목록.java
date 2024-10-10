import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			List<String> list = new ArrayList<>();
			
			for(int i = 0; i < n; i++) {
				list.add(br.readLine());
			}
			
			Collections.sort(list);
//			System.out.println(list);
			
			boolean suc = true;
			
			for(int i = 0; i < n - 1; i++) {
				int s = list.get(i).length();
				
				if(list.get(i+1).length() < s)
					continue;
				
//				System.out.println(list.get(i+1).substring(0, s));
				
				if(list.get(i+1).substring(0, s).equals(list.get(i))) {
					suc = false;
					break;
				}
			}
			
			if(suc)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
    }
}