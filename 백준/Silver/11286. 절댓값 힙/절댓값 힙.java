import java.io.*;
import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		int N;
		int num;
		List<Integer> list = new ArrayList<>();
		
		N = Integer.parseInt(br.readLine());
		list.add(Integer.MIN_VALUE);
		
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(list.size() == 1) {
					sb.append(0).append("\n");
				}
				else {
					pop(list);
				}
			}
			else {
				add(list, num);
			}
//			System.out.println(num);
//			System.out.println(list);
		}
		System.out.println(sb);
	}

	private static void add(List<Integer> list, int num) {
		int cur;
		int parent;
		list.add(num);
		cur = list.size() - 1;
		while(cur != 0) {
			parent = cur / 2;
			if(isFirstSmaller(list, cur, parent)) {
				swap(list, cur, parent);
				cur = parent;
			}
			else
				break;
		}
	}

	private static void pop(List<Integer> list) {
		int cur;
		int leftChild, rightChild, smallChild;
		
		sb.append(list.get(1)).append("\n");
		list.set(1, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		
		cur = 1;
		while(true) {
			leftChild = cur * 2; 
			rightChild = cur * 2 + 1;
			
			if(leftChild > list.size() - 1) {
				break;
			}
			else if(leftChild <= list.size() - 1 && rightChild > list.size() - 1) {
				if(isFirstSmaller(list, leftChild, cur)) {
					swap(list, leftChild, cur);
					cur = leftChild;
				}
				else
					break;
			}
			else {
				smallChild = (isFirstSmaller(list, leftChild, rightChild))
						? leftChild : rightChild;
				
				if(isFirstSmaller(list, smallChild, cur)) {
					swap(list, smallChild, cur);
					cur = smallChild;
				}
				else
					break;
			}
		}
	}
	
	private static boolean isFirstSmaller(List<Integer> list, int a, int b) {
		int x = list.get(a);
		int y = list.get(b);
		if(Math.abs(x) < Math.abs(y))
			return true;
		else if(Math.abs(x) == Math.abs(y)) {
			if(x < y)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	private static void swap(List<Integer> list, int a, int b) {
		int tmp = list.get(a);
		list.set(a, list.get(b));
		list.set(b, tmp);
	}
}

/*
45
10 -12
-20 35 40 -15
*/