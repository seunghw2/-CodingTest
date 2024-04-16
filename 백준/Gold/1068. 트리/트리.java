import java.io.*;
import java.util.*;

public class Main {
    public static List<List<Integer>> treeList = new ArrayList<>();
    public static int root, leaf, removeNode;
    
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N;
        
        N = Integer.parseInt(br.readLine());
        
        for(int n = 0; n < N; n++){
            treeList.add(new ArrayList<>());
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int n = 0; n < N; n++){
            int num = Integer.parseInt(st.nextToken());
            
            if(num == -1){
                root = n;
            }
            else{
                treeList.get(num).add(n);    
            }
        }
        
        removeNode = Integer.parseInt(br.readLine());
        
        if(removeNode == root){
            System.out.println(leaf);
        }
        else{
            traverse(root);
            System.out.println(leaf);    
        }
        
    }
    
    public static void traverse(int parent){
        if(treeList.get(parent).size() == 0){
            leaf += 1;
        }
        else if(treeList.get(parent).size() == 1){
            if(treeList.get(parent).get(0) == removeNode)
                leaf += 1;
            else
                traverse(treeList.get(parent).get(0));
        }
        else{
            for(int child: treeList.get(parent)){
                if(child == removeNode)
                    continue;
                else
                    traverse(child);
            }
        }
    }
}