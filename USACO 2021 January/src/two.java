
import java.util.*;

public class two {
	
	static String drawing;
	static int n, q;
	static pair[] cand;
	static int[] ans;
	static char[] alphabet;
	static Scanner in;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(System.in);
			
			init();
			solve();
			for(int i = 0; i < q; i++) {
				System.out.println(ans[i]);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void init() {
		n = in.nextInt();
		q = in.nextInt();
		in.nextLine();
		
		drawing = in.nextLine();
		
		cand = new pair[q];
		
		for(int i = 0; i < q; i++) {
			pair temp = new pair(in.nextInt(), in.nextInt());
			in.nextLine();
			cand[i] = temp;
		}
		
		alphabet = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		ans = new int[q];
	}
	
	public static void solve() {
		
		for(int i = 0; i < q; i++) {
			
			int t1 = cand[i].a;
			int t2 = cand[i].b;
			
			//System.out.println(t1 + " " + t2);
			
			String pto = "";
			
			if(t1 == 1 && t2 == drawing.length()) ans[i] = 0;
			else if(t1 == 1) {
				pto = drawing.substring(t2);
				int count = count(pto);
				ans[i] = count;
			}
			else if(t2 == drawing.length()) {
				pto = drawing.substring(0, t1-1);
				//System.out.println(pto);
				int count = count(pto);
				ans[i] = count;
			}
			else {
				pto = drawing.substring(0, t1-1);
				String ptt = drawing.substring(t2);
				int count1 = count(pto);
				int count2 = count(ptt);
				ans[i] = count1+count2;
			}
		}
		
	}
	public static int count(String drawing) {
		int count = 0;
		for(int alph = 0; alph < 26; alph++) {
			char temp = alphabet[alph];
			if(drawing.indexOf(temp) < 0) continue;
			int lastInd = -1;			
			for(int j = 0; j < drawing.length(); j++) {
				//System.out.println(drawing + " " + drawing.charAt(j) + " " + temp + " " + lastInd + " " + count);
				if(drawing.charAt(j) == temp) {
					count++;
					if(lastInd != -1 && check(j, lastInd, drawing)) count--;
					lastInd = j;
				}
			}
		}
		return count;
	}

	public static boolean check(int rn, int last, String drawing) {
		if(rn-1 == last) return true;
		for(int i = last+1; i < rn; i++) {
			if(drawing.charAt(i) < drawing.charAt(rn)) return false;
		}
		return true;
	}
}

class pair implements Comparable<pair> {

	public int a;
	public int b;
	
	public pair(int one, int two){
		a = one;
		b = two;
	}
	
	public int compareTo(pair arg0) {
		return 0;
	}
	
}