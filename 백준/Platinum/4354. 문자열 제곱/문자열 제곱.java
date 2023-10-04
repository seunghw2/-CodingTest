import java.io.*;
import java.util.*;

public class Main {
    public static char[] P ;
    public static int sizeP;
    public static int[] table;
    public static List<Integer> ansList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();
        int len;

        while(true) {
            String line = br.readLine();

            if(line.equals("."))
                break;

            sizeP = line.length();
            P = new char[sizeP];
            table = new int[sizeP];

            for (int i = 0; i < sizeP; i++) {
                P[i] = line.charAt(i);
            }

            makeTable();

            len = table.length - table[table.length - 1];
            if (table.length % len == 0) {
                sb.append(table.length / len).append("\n");
            } else
                sb.append(1).append(" ");
        }

        System.out.println(sb);
    }

    public static void makeTable(){
        int j = 0;

        for(int i = 1; i < sizeP; i++){
            while(j > 0 && P[i] != P[j]){
                j = table[j - 1];
            }
            if(P[i] == P[j]){
                table[i] = ++j;
            }
        }
    }
}