import java.io.*;
import java.util.*;

class Main {
    public static List<Integer> shuffle(List<Integer> cards, int N, int k){
        List<Integer> shffuledCards, tmpFirst, tmpSecond, tmpThrid;
        int pow2k = (int)Math.pow(2, k);

        tmpFirst = new ArrayList<>(cards.subList(N - pow2k, N));
        tmpSecond = new ArrayList<>(cards.subList(0, N - pow2k));
        tmpFirst.addAll(tmpSecond);
        shffuledCards = tmpFirst;

        while(pow2k > 1){
            pow2k = pow2k / 2;
            tmpFirst = new ArrayList<>(shffuledCards.subList(pow2k, pow2k * 2));
            tmpSecond = new ArrayList<>(shffuledCards.subList(0, pow2k));
            tmpThrid = new ArrayList<>(shffuledCards.subList(pow2k * 2, N));
            tmpFirst.addAll(tmpSecond);
            tmpFirst.addAll(tmpThrid);
            shffuledCards = tmpFirst;
        }
        
        return shffuledCards;
    }

    public static boolean isSame(int N, List<Integer> l1, List<Integer> l2){
        for(int i = 0; i < N; i++){
        	int a = l1.get(i);
        	int b = l2.get(i);
        	if (a != b)
        		return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < N; i++){
            res.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> cards = new ArrayList<>();
        for(int i = 1; i < N+1; i++){
            cards.add(i);
        }
        List<Integer> firstShuffledCards, doubleShuffledCards;

        for(int i = 1; i < 10; i++){
        	if(Math.pow(2, i) >= N)
        		break;
            firstShuffledCards = shuffle(cards, N, i);
            for(int j = 1; j < 10; j++){
            	if(Math.pow(2, j) >= N)
            		break;
                doubleShuffledCards = shuffle(firstShuffledCards, N, j);
                if(isSame(N, doubleShuffledCards, res)){
                    System.out.println(i+" "+j);
                    return;
                }
            }
        }
    }
}