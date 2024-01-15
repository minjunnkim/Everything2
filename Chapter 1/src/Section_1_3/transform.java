/*
ID: ckandre1
LANG: JAVA
TASK: transform
 */
package Section_1_3;

import java.util.*;
import java.io.*;

public class transform {

	static int n, ans;
	static String[] org, cha;
	static String newa;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("transform.in"));
			out = new PrintWriter(new File("transform.out"));
			
			init();
			System.out.println(Arrays.toString(ni(cha)));
			out.println(solve());
			
			in.close();
			out.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	static void init() {
		ans = 7;
		n = in.nextInt(); in.nextLine();
		org = new String[n];
		cha = new String[n];
	    newa = "";
	    String temp = "";
		for(int i = 0; i < n; i++) {
			temp = in.nextLine();
			org[i] = temp;
			cha[i] = temp;
		}
		for(int i = 0; i < n; i++) {
			newa += in.nextLine();
		}
	}
	static int solve() {
		if(ArrToStr(ni(cha)).equals(newa)) ans = 1;
		else if(ArrToStr(ni(ni(cha))).equals(newa)) ans = 2;
		else if(ArrToStr(ni(ni(ni(cha)))).equals(newa)) ans = 3;
		else if(ArrToStr(re(cha)).equals(newa)) ans = 4;
		else if(ArrToStr(re(ni(cha))).equals(newa) || ArrToStr(re(ni(ni(cha)))).equals(newa) || ArrToStr(re(ni(ni(ni(cha))))).equals(newa)) ans = 5;
		else if(ArrToStr(cha).equals(newa)) ans = 6;
		
		return ans;
	}
	static String[] ni(String[] cha) {
		String [] ans = new String[n];
		for(int j = 0; j < n; j++) {
			String s = "";
			for(int i = n-1; i >= 0; i--) {
				s += cha[i].charAt(j)+"";
			}
			ans[j] = s;
		}
		return ans;
	}
	
	static String[] re(String[] cha) {
		String[] ans = new String[n];
		for(int i = 0; i < n; i++) {
			ans[i] = new StringBuilder(cha[i]).reverse().toString();
		}
		return ans;
		
	}
	static String ArrToStr(String[] cha) {
		String ans = "";
		for(int i = 0; i < n; i++) {
			ans += cha[i];
		}
		return ans;
	}
}
