package _15_December;

import java.util.*;
import java.io.*;

public class speeding {

	static Scanner in;
	static PrintWriter out;
	static int[] road, roadB;
	static int x, y;
	
	public static void main(String[] args) {
		try { 
			in = new Scanner(new File("speeding.in"));
			out = new PrintWriter(new File("speeding.out"));
			
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
		x = in.nextInt();
		y = in.nextInt();
		
		road = new int[100];
		roadB = new int[100];
		
		int e = 0;
		for(int i = 0; i < x; i++) {
			int temp = in.nextInt();
			int tempi = in.nextInt();
			for(int j = e; j < temp + e; j++ ) {
				road[j] = tempi;
			}
			e += temp;
			
		}

		int d = 0;
		for(int i = 0; i < y; i++) {
			int temp = in.nextInt();
			int tempi = in.nextInt();
			for(int j = d; j < temp + d; j++ ) {
				roadB[j] = tempi;
			}
			d += temp;
			
		}
		
	}
	
	private static int solve() {
		int max = 0;
		for(int i = 0; i < 100; i++) {
			if(roadB[i] > road[i]) {
				if(roadB[i]-road[i] > max) {
					max = roadB[i]-road[i];
				}
			}
		}
		
		return max;
	}

}
