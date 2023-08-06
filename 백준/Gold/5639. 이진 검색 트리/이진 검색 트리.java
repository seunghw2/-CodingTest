import java.io.*;
import java.util.Arrays;

public class Main {
    public static class Node{
        int num;
        Node left;
        Node right;

        public Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        public void insert(int n){
            if(n < num){
                if(this.left == null){
                    this.left = new Node(n, null, null);
                }
                else{
                    this.left.insert(n);
                }
            }
            else{
                if(this.right == null){
                    this.right = new Node(n, null, null);
                }
                else{
                    this.right.insert(n);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num;
        String line;

        num = Integer.parseInt(br.readLine());
        Node root = new Node(num, null, null);

        while(true){
            line = br.readLine();
            if(line == null || line == "") {
                break;
            }
            num = Integer.parseInt(line);
            root.insert(num);
        }

        postOrder(root);
    }

    public static void postOrder(Node n){
        if(n == null)
            return;

        postOrder(n.left);
        postOrder(n.right);
        System.out.println(n.num);
    }
}