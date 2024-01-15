package _18_December;

import java.util.*;
import java.io.*;

public class backforth {
	
	static Scanner in;
	static PrintWriter out;
	static int milk;
	static ArrayList<Integer> l1, l2;
	static HashSet<Integer> possible;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("backforth.in"));
			out = new PrintWriter(new File("backforth.out"));
			
			init();
			solve();
			out.println(possible.size());
			
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	static void init() {
		milk = 1000;
		possible = new HashSet<Integer>();
		l1 = new ArrayList<Integer>();
		l2 = new ArrayList<Integer>();
		
		for(int i = 0; i < 10; i++) {
			l1.add(in.nextInt());
		}
		for(int i = 0; i < 10; i++) {
			l2.add(in.nextInt());
		}
	}
	
	static void solve() {
		rec(0);
	}
	
	
	static void rec(int d) {
		if (d == 4) {
			possible.add(milk);
			return;
		}
		
		if(d % 2 == 0) {
			for(int i = 0; i < l1.size(); i++) {
				milk -= l1.get(i);
				int t = l1.remove(i);
				l2.add(t);
				
				rec(d+1);
				
				t = l2.remove(l2.size()-1);
				l1.add(i,t);
				milk += l1.get(i);
			}
		}
		
		else {
			for (int i = 0; i < l2.size(); i++) {
					
					milk += l2.get(i);
					int t = l2.remove(i);
					l1.add(t);
					
					rec(d+1);
					
					t = l1.remove(l1.size()-1);
					l2.add(i,t);
					milk -= l2.get(i);
			}
		}
	}
}