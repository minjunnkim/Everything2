package _17_January;

import java.util.*;
import java.io.*;

public class cowdance {

	static Scanner in;
	static PrintWriter out;
	static int n, t;
	static int[] d;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("cowdance.in"));
			out = new PrintWriter(new File("cowdance.out"));
			
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
		t = in.nextInt();
		d = new int[n];
		
		for(int i = 0; i < n; i++) {
			d[i] = in.nextInt();
		}
	}

	private static int solve() {
		int up = n;
		int low = 0;
		int mid = 0;
		
		while(low <= up) {
			mid = (low+up)/2;
			System.out.println(mid);
			if(f(mid)) up = mid-1;
			else low = mid+1;
		}
		
		return low;
		
	}
	
	private static boolean f(int g) {
		PriorityQueue<Integer> q= new PriorityQueue<Integer>();
		for(int i = 0; i < g; i++) {
			q.add(d[i]);
		}
		for(int i = 0; i < n-g; i++) {
			int temp = q.poll() + d[g+i];
			if(temp > t) return false;
			else q.add(temp);
		}
		
		return true;
	}
}
