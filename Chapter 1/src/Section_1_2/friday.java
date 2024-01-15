/*
ID: ckandre1
LANG: JAVA
TASK: friday
 */

package Section_1_2;

import java.util.*;
import java.io.*;

public class friday {

	static Scanner in;
	static PrintWriter out;
	static int n;
	static int[] leapm;
	static int[] m;
	static int[] output;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("friday.in"));
			out = new PrintWriter(new File("friday.out"));
			
			init();
			out.println(solve());
			
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	static void init() {
		n = in.nextInt();
		leapm = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		m = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		output = new int[7];
	}
	
	static String solve() {
		int year = 1900;
		int day = 13;
		for(int i = year; i < year+n; i++) {
			for(int j = 1; j <= 12; j++) {
				output[day%7]++;
				day += m[j];
				if(j == 2 && isLeap(i)) day++;
			}
		}
		String result = Integer.toString(output[6]);
		for(int i = 0; i < 6; i++) {
			result += " " + output[i];
		}
		
		return result;
	}
	
	static boolean isLeap(int x) {
		return x%100==0 && x%400==0 || x%100!=0 && x%4==0;
	}
}
