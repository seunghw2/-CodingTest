import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		Stack<int[]> stack = new Stack<>();		// 업무의 정보를 담는 stack
		
		int N = Integer.parseInt(br.readLine());
		int score = 0;	// 성적
		int[] item;
		
		int a, b, c;
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			if(a == 1) {		// 만약 일을 받았다면
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				stack.add(new int[] {b, c});		// stack에 일 추가
			}
			
			if(!stack.isEmpty()) {
				item = stack.peek();		// 가장 최근에 받은 일
				
				item[1] -= 1;		// 시간 -1
				
				if(item[1] == 0) {	// 시간이 0이 된다면
					score += item[0];	// 점수 증가
					stack.pop();	// 업무 목록에서 제거
				}
			}
		}
		System.out.println(score);	// 점수 출력
	}		
}