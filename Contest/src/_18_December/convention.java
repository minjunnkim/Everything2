package _18_December;

import java.util.*;
import java.io.*;

public class convention {

	static int n, m, c;
	static int[] t;
	static Scanner in;
	static PrintWriter out;

	public static void main(String[] args) {
		try {
			in = new Scanner(new File("convention.in"));
			out = new PrintWriter(new File("convention.out"));
			
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
		c = in.nextInt();
		t = new int[n];
		
		for(int i = 0 ; i < n; i++) {
			t[i] = in.nextInt();
		}
		
		Arrays.sort(t);;
	}

	private static int solve() {
		int low = 0;
		int up = t[n-1]*2;
		int mid = 0;
		
		while(low<=up) {
			mid = (low+up)/2;
			if(f(mid)) up = mid-1;
			else low = mid+1;
		}
		
		return low;
	}
	
	private static boolean f(int g) {
		int k = 0; 
		for(int i = 0; i < m; i++) {
			int a = k;
			while(a < n && t[a]-t[k] <= g && a-k < c) {
				a++;
			}
			if(a == n) return true;
			k = a;
		}
		return false;
	}
}

