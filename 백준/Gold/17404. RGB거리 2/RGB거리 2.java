import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // BOJ에서 클래스 이름은 Main이어야 합니다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 집의 수 N을 입력받습니다.
        int N = Integer.parseInt(br.readLine());
        
        // 비용을 저장할 배열. cost[i][c]는 i번째 집을 c색(R=0, G=1, B=2)으로 칠하는 비용입니다.
        int[][] cost = new int[N+1][3];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); // 빨강
            cost[i][1] = Integer.parseInt(st.nextToken()); // 초록
            cost[i][2] = Integer.parseInt(st.nextToken()); // 파랑
        }
        
        final int INF = 1000000000;
        int answer = INF;
        
        // 첫 번째 집의 색을 각각 빨강, 초록, 파랑으로 고정하고 경우를 나눕니다.
        for(int firstColor = 0; firstColor < 3; firstColor++) {
            // dp[i][c]는 i번째 집을 c색으로 칠했을 때의 최소 비용을 저장합니다.
            int[][] dp = new int[N+1][3];
            for(int i = 1; i <= N; i++) {
                for(int c = 0; c < 3; c++) {
                    dp[i][c] = INF;
                }
            }
            
            // 첫 번째 집의 색을 고정합니다.
            dp[1][firstColor] = cost[1][firstColor];
            // 나머지 색은 초기화된 INF 값을 유지합니다.
            
            // 두 번째 집부터 N번째 집까지 색칠합니다.
            for(int i = 2; i <= N; i++) {
                for(int c = 0; c < 3; c++) { // 현재 집의 색
                    for(int pc = 0; pc < 3; pc++) { // 이전 집의 색
                        if(c != pc) {
                            dp[i][c] = Math.min(dp[i][c], dp[i-1][pc] + cost[i][c]);
                        }
                    }
                }
            }
            
            // N번째 집의 색이 첫 번째 집의 색과 다르도록 최소 비용을 찾습니다.
            for(int lastColor = 0; lastColor < 3; lastColor++) {
                if(lastColor == firstColor) continue;
                answer = Math.min(answer, dp[N][lastColor]);
            }
        }
        
        System.out.println(answer);
    }
}