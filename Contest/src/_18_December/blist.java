package _18_December;

import java.util.*;
import java.io.*;

public class blist {
	
	static Scanner in;
	static PrintWriter out;
	static int n, total, available;
	static int[][] cows;
	static int[] time;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("blist.in"));
			out =new PrintWriter(new File("blist.out"));
			
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
		cows = new int[n][3];
		time = new int[1001];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				cows[i][j] = in.nextInt();
			}
		}
	}
	
	static int solve() {
		for(int j = 0; j < n; j++) {
			for(int i = cows[j][0]; i <= cows[j][1]; i++ ) {
					time[i] += cows[j][2];
			
			
			}
		}
					
		Arrays.sort(time);
		return time[1000];
	}

}