package _19_December;

import java.util.*;
import java.io.*;

public class gymnastics {

	static Scanner in;
	static PrintWriter out;
	static int k, n, t;
	static String[] arr;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("gymnastics.in"));
			out = new PrintWriter(new File("gymnastics.out"));
			
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
		k = in.nextInt();
		n = in.nextInt();
		t = 0;
		
		arr = new String[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = in.next();
		}
		
		for(int j = 0; j < n-1; j++) {
			for(int k = j+1; k < n; k++) {
				t++;
			}
		}

		if(in.hasNextLine()) {
			in.nextLine();
		}
	}
	
	private static int solve() {
		
		if(n == 1) return 1;
		
		ArrayList<String> temp = new ArrayList<String>();
		
		for(int j = 0; j < n-1; j++) {
			
			for(int k = j+1; k < n; k++) {
				temp.add(arr[j]);
				temp.add(arr[k]);
			}	
		}	
		
		for(int u = 0; u < k-1; u++) {
			String tempstr = in.nextLine();
			for(int i = 0; i < temp.size(); i+=2) {
				if(tempstr.indexOf(temp.get(i)) >= tempstr.indexOf(temp.get(i+1))) {
					temp.remove(i);
					temp.remove(i);
					i-=2;
				}
				
				
			}
		}
		
		
		return temp.size()/2;
	}

}
