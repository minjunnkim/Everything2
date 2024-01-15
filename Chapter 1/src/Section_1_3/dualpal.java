/*
ID: ckandre1
LANG: JAVA
TASK: dualpal
 */

package Section_1_3;

import java.util.*;
import java.io.*;

public class dualpal {
	
	static int N, S;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("dualpal.in"));
			out= new PrintWriter(new File("dualpal.out"));
			
			init();
			solve();
			
			in.close();
			out.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	static void init() {
		N = in.nextInt();
		S = in.nextInt();
	}
	
	
	static void solve() {
		int c = 0;
		int temp = S+1;
		while(c != N) {
			int pc = 0;
			for(int j = 2; j <= 10; j++) if(isPalindrome(baseConversion(Integer.toString(temp), 10, j))) pc++;
			if(pc >= 2) {
				c++;
				out.println(temp);
			}
			temp++;
			System.out.println(temp);
		}
			
	}
	
	static String baseConversion(String number, int sBase, int dBase) {
		return Integer.toString(Integer.parseInt(number, sBase), dBase);
	}
	
	static boolean isPalindrome(String s) {
		int idx = s.length() -1;
		for(int i = 0; i < s.length() /2; i++) {
			if(s.charAt(i) != s.charAt(idx)) 
				return false;
			idx--;
		}
		return true;
	}
	

}
