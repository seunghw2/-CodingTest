import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);

        String line = br.readLine();

        for (int i = 0; i < line.length(); i++) {
//            System.out.println(stack);
//            System.out.println(sb);
//            System.out.println();

            char now = line.charAt(i);
            int num = ((int) now) - 'A';

            if(num >= 0 && num < 26){
                sb.append(now);
            }
            else if(now == '('){
                stack.add(now);
            }
            else if(now == ')'){
                char top;

                while(!stack.isEmpty()){
                    top = stack.pop();
                    if(top == '(') {
                        break;
                    }
                    sb.append(top);
                }
            }
            else if(now == '+' || now == '-' || now == '*' || now == '/'){
                if(!stack.isEmpty()){
                    char top = stack.peek();

                    if(top == '(') {
                        stack.add(now);
                        continue;
                    }

                    if(map.get(now) > map.get(top)){
                        stack.add(now);
                    }
                    else{
                        while(!stack.isEmpty()){
                            top = stack.peek();
//                            System.out.println(top);
                            if(top == '(') {
                                break;
                            }

                            if(map.get(top) >= map.get(now)) {
                                sb.append(stack.pop());
                            }
                            else
                                break;
                        }
                        stack.add(now);
                    }
                }
                else
                    stack.add(now);
            }
            else{
                throw new IllegalArgumentException();
            }
        }

        while (!stack.isEmpty()) {
            char top = stack.pop();
            if(top != '(')
                sb.append(top);
        }

        System.out.println(sb);
    }
}