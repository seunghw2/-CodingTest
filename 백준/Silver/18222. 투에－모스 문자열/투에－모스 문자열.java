import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger idx = new BigInteger(br.readLine());
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");

        idx = idx.subtract(one);

        int cnt = 0;

//        idx = idx.subtract(two.pow(idx.bitLength() - 1));
//        System.out.println(idx);
//
        while(idx.compareTo(one) > 0){
            idx = idx.subtract(two.pow(idx.bitLength() - 1));
            cnt = (cnt + 1) % 2;
        }

        if(idx.compareTo(one) == 0){
            System.out.println((cnt == 0) ? 1 : 0);
        }
        else{
            System.out.println((cnt == 0) ? 0 : 1);
        }
    }
}