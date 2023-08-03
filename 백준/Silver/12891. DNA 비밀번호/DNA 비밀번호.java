import java.io.*;
import java.util.*;

class Main {
	public static Map<Character, Integer> ACGT = new HashMap<>();
	public static int S, P;
	public static int A, C, G, T;
	
	public static void main(String[] args) throws IOException {
		int ans = 0;
		String dna;
		char cur, prev;

//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		dna = br.readLine();
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		ACGT.put('A', 0);
		ACGT.put('C', 0);
		ACGT.put('G', 0);
		ACGT.put('T', 0);
		
		for (int i = 0; i < P; i++) {
			cur = dna.charAt(i);
			ACGT.put(cur, ACGT.get(cur) + 1);
		}
		
		if(isPossible()) 
			ans += 1;

		for (int i = 1; i <= S - P; i++) {
			prev = dna.charAt(i-1);
			cur = dna.charAt(i + P - 1);
			
			ACGT.put(prev, ACGT.get(prev) - 1);
			ACGT.put(cur, ACGT.get(cur) + 1);
			
			if(isPossible()) 
				ans += 1;
		}

		System.out.println(ans);
	}

	private static boolean isPossible() {
		if(ACGT.get('A') >= A && ACGT.get('G') >= G && ACGT.get('C') >= C && ACGT.get('T') >= T)
			return true;
		else
			return false;
	}
}