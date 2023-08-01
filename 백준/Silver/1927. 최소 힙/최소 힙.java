import java.io.*;
import java.util.*;

class Main {
	public static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		int N, num;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		list.add(-1);
		
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(list.size() == 1) {
					sb.append("0\n");
				}
				else
					sb.append(popMin()+"\n");
			}
			else {
				list.add(num);
				sortMin();
			}
		}
		
		System.out.println(sb);
	}

	public static void swapList(int x, int y) {
		int temp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, temp);
	}
	
	private static void sortMin() {
		int cur = list.size() - 1;
		int parent;
		while(cur != 1) {
			parent = cur / 2;
			if(list.get(cur) < list.get(parent)) {
				swapList(cur, parent);
				cur /= 2;
			}
			else {
				return;
			}
		}
	}

	private static int popMin() {
		int ret = list.get(1);
		list.set(1, list.get(list.size() - 1));
		list.remove(list.size() - 1);

		int cur = 1;
		int leftChild, rightChild, changeChild;
		while(true) {
			leftChild = cur * 2;
			rightChild = cur * 2 + 1;

			if(leftChild < list.size()) {
				if(rightChild < list.size()) {
					changeChild = (list.get(leftChild) > list.get(rightChild)) ? rightChild : leftChild;
					if(list.get(cur) > list.get(changeChild)) {
						swapList(cur, changeChild);
						cur = changeChild;
					}
					else
						break;
				}
				else {
					if(list.get(cur) > list.get(leftChild)) {
						swapList(cur, leftChild);
						cur = leftChild;
					}
					else
						break;
				}				
			}
			else {
				break;
			}
		}
		
		return ret;
		
	}
}