import java.io.*;
import java.util.*;

import static java.lang.System.exit;

class Main {
    public static int convert(char c){
        if((int)c >= 97)
            return (int)c - 96;
        else
            return (int)c - 38;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int tot = 0;
        for(int i = 0; i < word.length(); i++){
            tot += convert(word.charAt(i));
        }
//        System.out.println(tot);

        for(int i = 2; i < tot; i++) {
            if (tot % i == 0) {
                System.out.println("It is not a prime word.\n");
                exit(0);
            }
        }

        System.out.println("It is a prime word.");
    }
}