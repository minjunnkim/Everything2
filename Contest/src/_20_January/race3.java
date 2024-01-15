package _20_January;
/*
ID: ckandrew
TASK: race
LANG: java
 */
import java.util.*;
import java.io.*;

public class race3 {

	static Scanner in;
	static PrintWriter out;
	static int k, n;
	static int[] x, ans;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("race.in"));
		out = new PrintWriter(new File("race.out"));

		init();
		solve();
		
		in.close();
		out.close();
	}
	
	private static void init() {
		k = in.nextInt();
		n = in.nextInt();
		x = new int[n];
		ans = new int[n];
		
		for(int i = 0; i < n; i++) {
			x[i] = in.nextInt();
		}
	}
	
	private static void solve() {
		
		for(int i = 0; i < n; i++) {
			int count = 2;
			int tot = 1;
			int current = 1;
			while(tot+x[i] < k) {
				if(canRaise(tot, current, i)) {
					current++;
					tot+=current;
					count++;
				}
				else if(canContinue(tot, current, i)) {
					tot+=current;
					count++;
				}
				else if(canLower(tot,current,i)) {
					current = current-1;
					tot+=current;
					count++;
				}
				else {
					x[i] = x[i]-1;
				}
				
			}
			
			ans[i] = count;
		}
		
		if(k == 1) out.println(1);
		else {
			for(int i = 0; i < n; i++) {
				out.println(ans[i]);
			}
		}
		
	}
	
	private static boolean canRaise(int tot, int current, int i) {
		int raised = current+1;
		int total = 0;

		if(x[i] > raised) {
			for(int j = raised; j < x[i]; j++) {
				total += j;
			}

			if(total+tot >= k) return false;
			else return true;
		}
		else if(x[i] < raised) {
			for(int j = raised; j > x[i]; j--) {
				total+=j;
			}
			if(total + tot >= k) return false;
			else return true;
		}
		else {
			if(raised + tot >= k) return false;
			else return true;
		}
	}
	
	private static boolean canContinue(int tot, int current, int i) {
		int total = 0;
		if(x[i] > current) {
			for(int j = current; j < x[i]; j++) {
				total += j;
			}
			if(total+tot >= k) return false;
			else return true;
		}
		else if(x[i] < current) {
			for(int j = current; j > x[i]; j--) {
				total+=j;
			}
			if(total + tot >= k) return false;
			else return true;
		}
		else {
			if(current + tot >= k) return false;
			else return true;
		}
	}
	
	private static boolean canLower(int tot, int current, int i) {
		int lowered = current-1;
		int total = 0;
		if(x[i] > lowered) {
			for(int j = lowered; j < x[i]; j++) {
				total += j;
			}
			if(total+tot >= k) return false;
			else return true;
		}
		else if(x[i] < lowered) {
			for(int j = lowered; j > x[i]; j--) {
				total+=j;
			}
			if(total + tot >= k) return false;
			else return true;
		}
		else {
			if(lowered + tot >= k) return false;
			else return true;
		}
	}
}
