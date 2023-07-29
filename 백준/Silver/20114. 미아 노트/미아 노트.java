import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

import static java.lang.System.exit;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        Character arr[][] = new Character[H][N*W];
        Character word[] = new Character[N];
        Arrays.fill(word, '?');
        String line;

        for(int i = 0; i < H; i++){
            line = br.readLine();
            for(int j = 0; j < N*W; j++){
                arr[i][j] = line.charAt(j);
            }
        }

        for(int y = 0; y < H; y++){
            for(int x = 0; x < N; x++){
                for(int i = 0; i < W; i++){
                    if(arr[y][x*W+i] != '?'){
                        word[x] = arr[y][x*W+i];
                        break;
                    }
                }
            }
        }

        for(int i = 0; i < word.length; i++){
            System.out.print(word[i]);
        }
    }
}