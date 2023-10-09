import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[][] arr;
	public static List<List<Integer>> comb = new ArrayList<>();
	public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int ans = Integer.MAX_VALUE;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int y = 0; y < N; y++){
	        StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int x = 0; x < N; x++){
        		arr[y][x] = Integer.parseInt(st.nextToken());
			}
        }

        getComb(-1, 0);

        for(List<Integer> startList: comb){

        	List<Integer> linkList = new ArrayList<>();
        	for(int i = 0; i < N; i++){
        		if(!startList.contains(i)){
        			linkList.add(i);
        		}
        	}
        	ans = Math.min(ans, Math.abs(getScore(startList) - getScore(linkList)));
        }
        System.out.println(ans);
    }

    public static int getScore(List<Integer> team){
    	int score = 0;

    	for(int j = 0; j < N / 2; j++){
	    	for(int i = j + 1; i < N / 2; i++){
	    		int a = team.get(i);
	    		int b = team.get(j);
	    		score += arr[a][b];
	    		score += arr[b][a];
	    	}
    	}

    	return score;
    }

    public static void getComb(int num, int depth){
    	if(depth == N / 2){
    		List<Integer> list = new ArrayList<>();
    		for(int item: stack)
    			list.add(item);
    		comb.add(list);
    		return;
    	}
    	for(int i = num + 1; i < N; i++){
    		stack.add(i);
    		getComb(i, depth + 1);
    		stack.pop();
    	}
    }
}