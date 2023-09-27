import java.io.*;
import java.util.*;

public class Main {
    public static int[][] paper = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        for(int y = 0; y < 9; y++){
            String line = br.readLine();
            for(int x = 0; x < 9; x++) {
                paper[y][x] = (int) (line.charAt(x) - '0');
            }
        }

        sudoku(0, 0);
    }

    public static void sudoku(int x, int y){
        if(x > 8){
            x = 0;
            y += 1;
        }
        if(y == 9){
            print();
            System.exit(0);
        }
        if(paper[y][x] == 0){
            for(int num = 1; num <= 9; num++){
                if(isPossible(x, y, num)){
                    paper[y][x] = num;
                    sudoku(x+1, y);
                    paper[y][x] = 0;
                }
            }
        }
        else
            sudoku(x+1, y);
    }

    public static boolean isPossible(int x, int y, int num){
        int startx = (int)(x / 3) * 3;
        int starty = (int)(y / 3) * 3;

//        if(x == 0 && y == 2)
//            System.out.println(startx + ", " + starty);

        for(int i = 0; i < 9; i++){
            if(paper[y][i] == num)
                return false;
            if(paper[i][x] == num)
                return false;
        }

        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 3; i++){
                if(paper[starty + j][startx + i] == num)
                    return false;
            }
        }
        return true;
    }

    public static void print(){
        for(int y = 0; y < 9; y++){
            for(int x = 0; x < 9; x++) {
                System.out.print(paper[y][x]);
            }
            System.out.println();
        }
    }
}