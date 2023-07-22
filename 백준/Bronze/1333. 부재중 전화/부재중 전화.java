import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Set<Integer> list = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int bellStart = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < L; j++) {
                list.add((L + 5) * i + j);
            }
        }

        while(true){
            if(list.contains(bellStart)){
                bellStart += D;
            }
            else{
                System.out.println(bellStart);
                break;
            }
        }

    }
}