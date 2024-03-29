/*
ID: ckandre1
LANG: JAVA
TASK: ride
 */

package Section_1_2;

import java.util.*;
import java.io.*;

public class ride {

	static Scanner in;
	static PrintWriter out;
	static String[] input;
	
	public static void main(String[] args) {
		
		try {
			
			in = new Scanner(new File("ride.in"));
			out = new PrintWriter(new File("ride.out"));
			
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
		input = new String[2];
		input[0] = in.nextLine();
		input[1] = in.nextLine();
	}
	
	static String solve() {
		
		int n1 = convert(input[0]);
		int n2 = convert(input[1]);
		
		if(n1==n2) return "GO";
		else return "STAY";
	}
	
	static int convert(String s) {
		int x = 1;
		
		for(int i = 0; i < s.length(); i++) {
			x *= (s.charAt(i)-'A'+1);
		}
		
		return x%47;
	}

}
