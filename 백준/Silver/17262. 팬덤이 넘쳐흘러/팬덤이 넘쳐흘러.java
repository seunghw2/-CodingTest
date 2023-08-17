import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Node> nodes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            nodes.add(new Node(s, e));
        }
        
        int lastStart = Integer.MIN_VALUE;
        int firstEnd = Integer.MAX_VALUE;
        
        for(Node item: nodes) {
        	lastStart = Math.max(lastStart, item.s);
        }
        for(Node item: nodes) {
        	firstEnd = Math.min(firstEnd, item.e);
        }
        
        if(lastStart > firstEnd)
        	System.out.println(lastStart - firstEnd);
        else
        	System.out.println(0);
        
    }

    static class Node {
        int s;
        int e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}