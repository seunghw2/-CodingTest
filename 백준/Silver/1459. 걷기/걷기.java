import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long X, Y, W, S;
        long t1, t2;

        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        if(X > Y){
            long tmp = X;
            X = Y;
            Y = tmp;
        }

        t1 = 0;
        t2 = 0;

        if(W * 2 > S){
            t1 += X * S;
        }
        else{
            t1 += X * W * 2;
        }

        if(W > S){
            if((Y - X) % 2 == 0){
                t2 += (Y - X) * S;
            }
            else{
                t2 += Math.floor((double) (Y - X) / 2) * 2 * S + W;
            }
        }
        else{
            t2 += (Y - X) * W;
        }

        System.out.println(t1 + t2);
    }
}