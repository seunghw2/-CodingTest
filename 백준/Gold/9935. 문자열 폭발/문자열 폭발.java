import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringBuilder sb = new StringBuilder();

		String line = br.readLine();
		String bomb = br.readLine();
		Character now;
		boolean isSame;
		
		for(int i = 0; i < line.length(); i++) {
			now = line.charAt(i);
			isSame = true;
			
			stack.add(now);
			
			if(stack.size() >= bomb.length()) {
				for(int j = 0; j < bomb.length(); j++) {
					if(stack.get(stack.size() - j - 1) != bomb.charAt(bomb.length() - j - 1)) {
						isSame = false;
						break;
					}
				}
				if(isSame) {
					for(int j = 0; j < bomb.length(); j++)
						stack.pop();
				}
			}
		}
		
		if(stack.size() > 0) {
			for(char item: stack)
				sb.append(item);
		}
		else
			sb.append("FRULA");
		
		System.out.println(sb);
	}
}