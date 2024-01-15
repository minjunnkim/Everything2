package _15_December;

import java.util.*;
import java.io.*;

public class paint {
	
	static Scanner in;
	static PrintWriter out;
	static int a,b, c, d;
	static int[] grid;
	
	public static void main(String[] args) {
		try { 
			in = new Scanner(new File("paint.in"));
			out = new PrintWriter(new File("paint.out"));
			
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
		a = in.nextInt();
		b = in.nextInt();
		in.nextLine();
		c = in.nextInt();
		d = in.nextInt();
		grid = new int[100];
		
		for(int i = a; i < b; i++) {
			grid[i]++;
		}
		for(int i = c; i < d; i++) {
			grid[i]++;
		}
	}
	
	private static int solve() {
		int count = 0;
		for(int i = 0; i < 100; i++) {
			if(grid[i] >= 1) count++;
		}
		
		return count;
	}

}
