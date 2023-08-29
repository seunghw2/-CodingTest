import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();

        int n, m, r;
        int a, b, c;
        int sum;
        int ans = 0;
        int[] items;
        int[][] dist;

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items= new int[n];
        dist = new int[n][n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            items[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = 100000;
            }
        }

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken());

            dist[a][b] = c;
            dist[b][a] = c;
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        for(int i = 0; i < n; i++) {
            sum = 0;
            for(int j = 0; j < n; j++) {
                if(dist[i][j] <= m)
                    sum += items[j];
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}