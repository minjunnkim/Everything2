package _19_Feburary;

import java.util.*;
import java.io.*;

public class revegetate {
	
	static Scanner in;
	static PrintWriter out;
	static String[] field, fav;
	static int n, m;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("revegetate.in"));
			out = new PrintWriter(new File("revegetate.out"));
			
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
		
		field = new String[n];
		field[0] = "1";
		for(int i = 1; i < n; i++) {
			field[i] = "1234";
		}
		fav = new String[n];
		
		for(int i = 0; i < m; i++) {
			int t1 = in.nextInt();
			int t2 = in.nextInt();
			
			if(fav[t1-1] == null) fav[t1-1] = Integer.toString(i+1);
			else fav[t1-1] += Integer.toString(i+1);
			if(fav[t2-1] == null) fav[t2-1] = Integer.toString(i+1);
			else fav[t2-1] += Integer.toString(i+1);
		}
		
		System.out.println(Arrays.toString(field));

		System.out.println(Arrays.toString(fav));
		
	}
	
	private static String solve() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < fav[i].length(); j++) {
				String temp = Character.toString(fav[i].charAt(j));
				
				for(int k = i+1; k < n; k++) {
					if(fav[k].contains(temp)) {
						field[k] = field[k].substring(1);
					}
				}
			}
		}
		
		String ans = "";
		
		for(int i = 0; i < n; i++) {
			ans += Character.toString(field[i].charAt(0));
		}
		
		return ans;
	}
}
