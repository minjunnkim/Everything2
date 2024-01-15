package _18_January;

import java.util.*;
import java.io.*;

public class outofplace {
	
	static Scanner in;
	static PrintWriter out;
	static int n;
	static int[] arr, sarr;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("outofplace.in"));
			out = new PrintWriter(new File("outofplace.out"));
			
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
		
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			in.hasNextLine();
		}

		sarr = arr.clone();
		Arrays.sort(sarr);
	}
	
	private static int solve() {
		int ans = -1;
		for(int i = 0; i < n; i++) {
			if(arr[i] != sarr[i]) {
				ans++;
			}
		}
		
		return ans;
	}

}
