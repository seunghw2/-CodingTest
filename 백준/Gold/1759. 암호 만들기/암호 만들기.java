import java.io.*;
import java.util.*;

public class Main {
    public static Set<Character> moSet = new HashSet<>();
    public static List<Character> charList = new ArrayList<>();
    public static StringBuilder passwordSb = new StringBuilder();
    public static Stack<Character> stack = new Stack<>();
    public static int L, C;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            charList.add(st.nextToken().charAt(0));    
        }
        
        charList.sort(Comparator.naturalOrder());
        
        initSet();
        
        traverse(-1, 0, 0, 0);
        
        System.out.println(passwordSb);
        
    }
    
    public static void traverse(int start, int depth, int mo, int ja){
        if(depth == L){
            if(mo >= 1 && ja >= 2){
                StringBuilder sb = new StringBuilder();
                
                for(char c: stack){
                    sb.append(c);
                }
                sb.append('\n');
                passwordSb.append(sb);    
            }
            return;
        }
        for(int i = start + 1; i < C; i++){
            stack.add(charList.get(i));
            if(moSet.contains(charList.get(i))){
                traverse(i, depth + 1, mo + 1, ja);
            }
            else{
                traverse(i, depth + 1, mo, ja + 1);
            }
            stack.pop();
        }
    }
    
    public static void initSet(){
        moSet.add('a');
        moSet.add('e');
        moSet.add('i');
        moSet.add('o');
        moSet.add('u');
    }
}