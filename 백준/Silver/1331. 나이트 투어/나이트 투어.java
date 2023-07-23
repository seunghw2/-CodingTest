import java.io.*;
import java.util.*;

import static java.lang.System.exit;

class Main {
    public static boolean isPossible(int[][] arr, int prevRow, int prevCol, int row, int col){
        if(Math.abs(col - prevCol) == 2 && Math.abs(row - prevRow) == 1)
            return true;
        else if(Math.abs(col - prevCol) == 1 && Math.abs(row - prevRow) == 2)
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[6][6];
        Set<Integer> set = new HashSet<Integer>();
        String input;
        int row, col;
        int prevRow = -1, prevCol = -1;
        int firstRow = -1, firstCol = -1;
        
        for(int i = 0; i < 36; i++){
            input = br.readLine();
            col = input.charAt(0) - 65;
            row = 6 - input.charAt(1) + '0';

            if(i == 0){
                firstRow = row;
                firstCol = col;
                prevRow = row;
                prevCol = col;
                set.add(row * 6 + col);
            }
            else {
                if (isPossible(arr, prevRow, prevCol, row, col) && !set.contains(row * 6 + col)) {
                    prevRow = row;
                    prevCol = col;
                    set.add(row * 6 + col);
                } else
                    break;
            }

            if (i == 35) {
                if (isPossible(arr, firstRow, firstCol, row, col)) {
                    System.out.println("Valid");
                    exit(0);
                } else
                    break;
            }
        }
        System.out.println("Invalid");
    }
}