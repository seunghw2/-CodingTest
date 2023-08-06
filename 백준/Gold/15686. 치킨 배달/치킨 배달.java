import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    public static int N, M;
    public static int[][] city;
    public static List<Point> chick = new ArrayList<>();
    public static List<Point> houses = new ArrayList<>();
    public static Stack<Point> stack = new Stack<>();
    public static List<Set<Point>> combination = new ArrayList<>();
    public static boolean[] isVisited;

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int tot;
        int ans = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];

        for(int j = 0; j < N; j++){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                city[j][i] = Integer.parseInt(st.nextToken());
                if(city[j][i] == 2) {
                    chick.add(new Point(i, j));
                }
                else if(city[j][i] == 1){
                    houses.add(new Point(i, j));
                }
            }
        }
        isVisited = new boolean[chick.size()];

        combinate(0, 0);

        for(Set<Point> set: combination){
//            for(Point p: set){
//                System.out.print("(" + p.x + ", " + p.y + ")\t");
//            }
//            System.out.println();
//
            tot = 0;
            for(Point house: houses){
//                System.out.println("(" + house.x + ", " + house.y + ") - " + bfs(set, house));
                tot += calc(set, house);
            }
//            System.out.println("TOT " + tot);
            ans = Math.min(ans, tot);
        }
        System.out.println(ans);
    }

    private static void combinate(int num, int depth) {
        if(depth == M){
            Set<Point> newSet = new HashSet<>();
            for(Point item: stack){
                newSet.add(item);
            }
            combination.add(newSet);
            return;
        }
        for(int i = num; i < chick.size(); i++){
            if(!isVisited[i]){
                stack.add(chick.get(i));
                isVisited[i] = true;
                combinate(i, depth+1);
                isVisited[i] = false;
                stack.pop();
            }
        }
    }

    private static int calc(Set<Point> set, Point house) {
        int dist = Integer.MAX_VALUE;

        for(Point p: set){
            dist = Math.min(dist, Math.abs(p.x - house.x) + Math.abs(p.y - house.y));
        }
        return dist;
    }
}