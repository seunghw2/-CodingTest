import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			List<List<Integer>> list = new ArrayList<>();
			for(int i = 0; i < 26; i++) {
				list.add(new ArrayList<>());
			}
			
			int max = 0;
			int min = Integer.MAX_VALUE;
			
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < W.length(); i++) {
				char c = W.charAt(i);
				int a = (int)(c - 'a');

				list.get(a).add(i);
			}
			
			for(int i = 0; i < 26; i++) {
				if(list.get(i).size() < K)
					continue;
				
				for(int j = 0; j < list.get(i).size() - K + 1; j++) {
					min = Math.min(min, list.get(i).get(j + K - 1) - list.get(i).get(j));
					max = Math.max(max, list.get(i).get(j + K - 1) - list.get(i).get(j));
//					System.out.println(i + ", " + min + ", " + max);
				}
			}
			
			if(min == Integer.MAX_VALUE && max == 0) {
				System.out.println(-1);
			}
			else
				System.out.println((min + 1) + " " + (max + 1));
		}
		
    }
}