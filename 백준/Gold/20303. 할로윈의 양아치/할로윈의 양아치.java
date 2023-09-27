import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, X;
    public static int[] candy;
    public static List<Item> itemList = new ArrayList<>();
    public static List<List<Integer>> graph = new ArrayList<>();

    public static class Item{
        int value;
        int cost;

        public Item(int value, int cost){
            this.value = value;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int Y;
        int[][] dp;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        candy = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            candy[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        getList();

        Y = itemList.size();
        dp = new int[Y+1][X];

        for(int y = 1; y <= Y; y++){
            Item item = itemList.get(y-1);

            for(int x = 0; x < X; x++){
                if(x >= item.cost)
                    dp[y][x] = Math.max(dp[y-1][x], dp[y-1][x-item.cost] + item.value);
                else
                    dp[y][x] = dp[y-1][x];
            }
        }

        System.out.println(dp[Y][X-1]);
    }

    public static void getList(){
        boolean[] isVisited = new boolean[N];
        Deque<Integer> dq = new ArrayDeque<>();

        for(int n = 0; n < N; n++){
            if(!isVisited[n]){
                List<Integer> friendList = new ArrayList<>();

                isVisited[n] = true;
                friendList.add(n);
                dq.addLast(n);

                while(!dq.isEmpty()){
                    int now = dq.pollFirst();
                    for(int i = 0; i < graph.get(now).size(); i++){
                        int next = graph.get(now).get(i);
                        if(!isVisited[next]){
                            isVisited[next] = true;
                            friendList.add(next);
                            dq.addLast(next);
                        }
                    }
                }

                // Item 구하기
                int cnt = friendList.size();
                int sum = 0;

                for(int i = 0; i < cnt; i++){
                    int friend = friendList.get(i);
                    sum += candy[friend];
                }

                Item item = new Item(sum, cnt);
                itemList.add(item);
            }
        }
    }
}