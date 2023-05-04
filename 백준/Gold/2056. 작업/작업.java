import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a, b, c;

        int cnt[] = new int[n + 1];
        int work[] = new int[n + 1];
        int item;
        int time = 0;

        // work 기준 오름차순 우선 순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(work[o1], work[o2]);
            }
        });

        // list 초기화
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            cnt[i] = 0;
            list.add(new ArrayList<>());
        }

        // list, cnt 초기화
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            work[i] = a;
            b = Integer.parseInt(st.nextToken());
            cnt[i] = b;
            for(int j = 0; j < b; j++){
                c = Integer.parseInt(st.nextToken());
                list.get(c).add(i);
            }
        }

        // 진입 차수 0인 작업 queue에 넣음
        for(int i = 1; i <= n; i++){
            if(cnt[i] == 0){
                pq.add(i);
            }
        }

        // 작업
        while(!pq.isEmpty()){
            item = pq.poll();
//            System.out.println("Out >>>" + item);
            time += work[item];
            for(int queueItem: pq){
//                System.out.println("Queue >>>" + queueItem);
                work[queueItem] -= work[item];
            }
//            System.out.println("work >>>" + Arrays.toString(work));
            for(int listItem: list.get(item)){
                cnt[listItem] -= 1;
                if (cnt[listItem] == 0){
//                    System.out.println("In >>>" + listItem);
                    pq.add(listItem);
                }
            }
        }

        System.out.print(time);
    }
}