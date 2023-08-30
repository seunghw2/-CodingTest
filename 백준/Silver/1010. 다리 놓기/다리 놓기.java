import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(combinate(b, a)).append("\n");
        }
        System.out.println(sb);
    }

    public static long combinate(int n, int r) {
        long ret = 1;

        if(r > n - r)
            r = n - r;

        for (int i = 0; i < r; i++) {
            ret *= (n-i);
        }
        for(int i = 1; i <= r; i++)
            ret /= i;

        return ret;
    }
}