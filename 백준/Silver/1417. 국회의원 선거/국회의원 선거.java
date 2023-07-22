import java.io.*;
import java.util.*;

import static java.lang.System.exit;

class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int me = Integer.parseInt(br.readLine());
        int maxVal;
        int maxIdx;
        int cnt = 0;

        if(N == 1){
            System.out.println(0);
            exit(0);
        }


        for (int i = 0; i < N-1; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        while(true){
            maxVal = Collections.max(list);
            maxIdx = list.indexOf(maxVal);
//            System.out.println(me + list.toString());

            if(me > maxVal){
                System.out.println(cnt);
                break;
            }
            else{
                me += 1;
                list.set(maxIdx, maxVal - 1);
                cnt += 1;
            }
        }
    }
}