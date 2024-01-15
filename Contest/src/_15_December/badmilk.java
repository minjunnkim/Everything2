package _15_December;

import java.util.*;
import java.io.*;

public class badmilk {

	static Scanner in;
	static PrintWriter out;
	static int n, m, d, s;
	static int[][] script, sick;
	static int[] milk;
	static ArrayList<Integer> whtlst;
	
	
	public static void main(String[] args) {
		try { 
			in = new Scanner(new File("badmilk.in"));
			out = new PrintWriter(new File("badmilk.out"));
			
			init();
			out.println(solve());
			
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		n = in.nextInt();
		m = in.nextInt();
		d = in.nextInt();
		s = in.nextInt();
		in.nextLine();
		
		whtlst = new ArrayList<Integer>();
		script = new int[d][3];
		sick = new int[s][2];
		milk = new int[m];
		
		for(int i = 0; i < d; i++) {
			for(int j = 0; j < 3; j++) {
				script[i][j] = in.nextInt();
			}
		}
		
		for(int i = 0; i < s; i++) {
			for(int j = 0; j < 2; j++) {
				sick[i][j] = in.nextInt();
			}
		}
		
	}
	
	private static int solve() {
		boolean[] tf = new boolean[n];
		int count = 0;
		for(int i = 0; i < m; i++ ) {
			for(int j = 0; j < s; j++) {
				int sickp = sick[j][0];
				int sickt = sick[j][1];
				
				for(int k = 0; k < d; k++) {
					if(script[k][0] == sickp && script[k][2] < sickt) {
						milk[script[k][1]-1]++;
					}
				}
				for(int k = 0; k < m; k++) {
					if(milk[k] == 0 && !whtlst.contains(k+1)) {
						whtlst.add(k+1);
					}
				}
			}
		}
		System.out.println(whtlst);
		
		for(int i = 0; i < d; i++) {
			if(!whtlst.contains(script[i][1])) {
				tf[script[i][0]-1] = true;
			}
		}
		for(int i = 0; i < n; i++) {
			if(tf[i] == true) count++;
		}
		return count;
	}
	
	

}
