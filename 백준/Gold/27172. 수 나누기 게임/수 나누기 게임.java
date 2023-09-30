import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] arr;
    public static int[] numbers = new int[1000001];
    public static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <= 1000000; i++)
            numbers[i] = i;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            numbers[num] = 1;
            arr[i] = num;
            map.put(num, 0);
        }

        for(int i = 0; i < N; i++){
            ett(arr[i]);
        }

        for(int i = 0; i < N; i++){
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }

    public static void ett(int num){
        for(int i = num * 2; i <= 1000000; i += num){
            if(numbers[i] == 1) {
                map.put(num, map.get(num) + 1);
                map.put(i, map.get(i) - 1);
            }
        }
    }
}