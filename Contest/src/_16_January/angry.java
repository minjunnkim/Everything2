package _16_January;

import java.util.*;
import java.io.*;

public class angry {

	static Scanner in;
	static PrintWriter out;
	static int[] hayBales;
	static int n;
	static boolean[] line;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("angry.in"));
			out = new PrintWriter(new File("angry.out"));
			
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
		hayBales = new int[n];
		
		for(int i = 0; i < n; i++) {
			hayBales[i] = in.nextInt();
		}
		
		Arrays.sort(hayBales);
		
		line = new boolean[hayBales[n-1]+1];
		
		for(int i = 0; i < n; i++) {
			line[hayBales[i]] = true;
		}
		
		
		System.out.println(n + " " + Arrays.toString(hayBales) + " " + Arrays.toString(line));
	}
	
	private static int solve() {
		int[] ansarr = new int[n];
		for(int i = 0; i < n; i++) {
			int count = 0;
			int t = 1;
			while(isValid(t, i) == true) {
				
			}
			
			ansarr[i] = count;
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			if(ansarr[i] > ans) ans = ansarr[i];
		}
		
		return ans;
	}
	
	private static boolean isValid(int t, int i) {
		if(line[hayBales[i]-t] == false || line[hayBales[i]+t] == true) return true;
		return false;
	}

}
