import java.io.*;
import java.util.*;

class Main {
	public static List<Integer> copyList(List<Integer> list, int start, int end){
		List<Integer> res = new ArrayList<>();
		for(int i = start; i < end; i++) {
			res.add(list.get(i));
		}
		return res;
	}
	
    public static List<Integer> shuffle(List<Integer> cards, int N, int k){
        List<Integer> shffuledCards, tmpFirst, tmpSecond, tmpThrid;
        int pow2k = (int)Math.pow(2, k);

        tmpFirst = copyList(cards, N-pow2k, N);
        tmpSecond = new ArrayList<>(cards.subList(0, N - pow2k));
        tmpSecond = copyList(cards, 0, N-pow2k);
        tmpFirst.addAll(tmpSecond);
        shffuledCards = tmpFirst;
//        System.out.println("First : " + k + " " + shffuledCards);

        while(pow2k > 1){
            pow2k = pow2k / 2;
            tmpFirst = copyList(shffuledCards, pow2k, pow2k * 2);
            tmpSecond = copyList(shffuledCards, 0, pow2k);
            tmpThrid = copyList(shffuledCards, pow2k * 2, N);
            
            tmpFirst.addAll(tmpSecond);
            tmpFirst.addAll(tmpThrid);
            shffuledCards = tmpFirst;
//            System.out.println(">>>" + k + " " + shffuledCards);
        }
        return shffuledCards;
    }

    public static boolean isSame(int N, List<Integer> l1, List<Integer> l2){
        for(int i = 0; i < N; i++){
            if(l1.get(i) != l2.get(i))
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

        double sqrtN = Math.sqrt(N);
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
                if(doubleShuffledCards.equals(res)){
                    System.out.println(i+" "+j);
                    return;
                }
            }
        }
    }
}