/*
ID: ckandre1
LANG: JAVA
TASK: barn1
 */
package Section_1_4;

import java.util.*;
import java.io.*;

public class barn0_5 {
	
	static int m, s, c;
	static int[] stall, pan;
	
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("barn1.in"));
			out = new PrintWriter(new File("barn1.out"));
			
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
		m = in.nextInt();
		s = in.nextInt();
		c = in.nextInt();
		stall = new int[c];
		pan = new int[m];
		for(int i = 0; i < c; i++) {
			stall[i] = in.nextInt(); in.nextLine();
		}
		Arrays.sort(stall);
		System.out.println(m + " " + s + " " + c + " " + Arrays.toString(stall) + " " + Arrays.toString(pan));
	}
	static int solve() {
		int ans = 0;
		int count = 0;
		int split = 0;
		int stidx = 0;
		int edidx = 0;
		System.out.println(Arrays.toString(pan));
		for(int i = 0; i < c; i++) {
			if(stall[i+1] - stall[i] > stall[i+2] - stall[i+1]) {
				edidx = i;
				if(count > 0 && stall[i+1] - stall[i] > stall[i+2] - stall[i+1] && stall[i+1]-stall[i] > split + ) {
					
				}
				else pan[count] = stall[edidx]-stall[stidx]+1;
				stidx = i+1;
				split = stall[i+1]-stall[i];
				count++;
			}
			System.out.println(i + " " + stall[i] + " " + stall[i+1] + " " + stall[i+2] + " " + Arrays.toString(pan) + " " + Arrays.toString(stall));
		}
		
		for(int i = 0; i < m; i++) {
			ans += pan[i];
		}
		return ans;
	}

}
