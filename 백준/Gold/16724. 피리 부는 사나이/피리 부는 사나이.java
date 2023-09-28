import java.io.*;
import java.util.*;

public class Main {
    public static int X, Y;
    public static int[] parent;
    public static char[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        parent = new int[X*Y];
        for(int y = 0; y < Y; y++){
            for(int x = 0; x < X; x++) {
                parent[X * y + x] = X * y + x;
            }
        }

        map = new char[X*Y];
        for(int y = 0; y < Y; y++){
            String line = br.readLine();
            for(int x = 0; x < X; x++) {
                map[X * y + x] = line.charAt(x);
            }
        }

        markParent();
        ans = countParent();

//        while(true){
//            markParent();
//            if(ans == countParent())
//                break;
//            else
//                ans = countParent();
//        }
        System.out.println(ans);
    }

    public static int countParent(){
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < X * Y; i++){
            set.add(getParent(i));
        }

        return set.size();
    }

    public static void markParent(){
        for(int i = 0; i < X * Y; i++){
            if(map[i] == 'L') {
                unionParent(i, i - 1);
            }
            else if(map[i] == 'R') {
                unionParent(i, i + 1);
            }
            else if(map[i] == 'U') {
                unionParent(i, i - X);
            }
            else if(map[i] == 'D') {
                unionParent(i, i + X);
            }
        }

        for(int i = 0; i < X * Y; i++){
            parent[i] = getParent(i);
        }
    }

    public static int getParent(int idx){
        if(parent[idx] == idx)
            return idx;
        return parent[idx] = getParent(parent[idx]);
    }

    public static void unionParent(int i1, int i2){
        int p1 = getParent(i1);
        int p2 = getParent(i2);

        if(p1 > p2){
            parent[p1] = p2;
        }
        else
            parent[p2] = p1;
    }

    public static void print(){
        for(int y = 0; y < Y; y++){
            for(int x = 0; x < X; x++) {
                System.out.print(parent[X * y + x]+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}