import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N, num;
		Queue<Integer> q = new LinkedList<>();
		
		N = Integer.parseInt(br.readLine());
		for(int i = 1; i < N+1; i++)
			q.add(i);
		
		while(q.size() != 1) {
			q.poll();
			q.add(q.poll());
		}

		System.out.println(q.poll());
		
	}
}