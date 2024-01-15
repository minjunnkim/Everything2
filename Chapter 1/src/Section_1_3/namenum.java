/*
ID: ckandre1
LANG: JAVA
TASK: namenum
 */
package Section_1_3;

import java.util.*;
import java.io.*;

public class namenum {
	
	static Scanner in;
	static Scanner map;
	static PrintWriter out;
	static String n;
	static int x;
	static int count;
	static ArrayList<String> str;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("namenum.in"));
			map = new Scanner(new File("dict.txt"));
			out = new PrintWriter(new File("namenum.out"));
			
			init();
			solve();
			if(count == 0) {
				out.println("NONE");
			}
			
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	static void init() {
		n = in.nextLine();
		x = n.length();
		str = new ArrayList<String>();
		count = 0;
	}
	static void solve() {
		while(map.hasNextLine()) {
			String temp = map.nextLine();
			if(temp.length() != x) continue;
			char[] c = temp.toCharArray();
			String ans = "";
			for(int i = 0;i < x; i++) {
				
				if(c[i] == 'A' || c[i] == 'B' || c[i] == 'C') ans += "2";
				else if(c[i] == 'D' || c[i] == 'E' || c[i] == 'F') ans += "3";
				else if(c[i] == 'G' || c[i] == 'H' || c[i] == 'I') ans += "4";
				else if(c[i] == 'J' || c[i] == 'K' || c[i] == 'L') ans += "5";
				else if(c[i] == 'M' || c[i] == 'N' || c[i] == 'O') ans += "6";
				else if(c[i] == 'P' || c[i] == 'R' || c[i] == 'S') ans += "7";
				else if(c[i] == 'T' || c[i] == 'U' || c[i] == 'V') ans += "8";
				else if(c[i] == 'W' || c[i] == 'X' || c[i] == 'Y') ans += "9";
				

				
			}

			if(ans.equals(n)) {
				out.println(temp);
				count++;
			}
		}
	}

}
