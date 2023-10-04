import java.io.*;
import java.util.*;

public class Main {
    public static char[] T, P ;
    public static int sizeT, sizeP;
    public static int[] table;
    public static int cnt = 0;
    public static List<Integer> ansList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();

        sizeT = line.length();
        T = new char[sizeT];
        for(int i = 0; i < sizeT; i++){
            T[i] = line.charAt(i);
        }

        line = br.readLine();

        sizeP = line.length();
        P = new char[sizeP];
        table = new int[sizeP];

        for(int i = 0; i < sizeP; i++){
            P[i] = line.charAt(i);
        }

        makeTable();

        KMP();

        sb.append(cnt).append("\n");
        
        for(int item: ansList){
            sb.append(item).append(" ");
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

    public static void KMP(){
        int j = 0;

        for(int i = 0; i < sizeT; i++){
            while(j > 0 && T[i] != P[j]){
                j = table[j-1];
            }
            if(T[i] == P[j]){
                if(j == sizeP - 1){
                    cnt += 1;
                    ansList.add((i + 1) - sizeP + 1);
                    j = table[j];
                }
                else
                    j++;
            }
        }
    }
}