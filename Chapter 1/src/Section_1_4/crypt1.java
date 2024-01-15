/*
ID: ckandre1
LANG: JAVA
TASK: crypt1
 */
package Section_1_4;

import java.util.*;
import java.io.*;

public class crypt1 {
	
	static int n, arr[], thr[], two[];
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("crypt1.in"));
			out = new PrintWriter(new File("crypt1.out"));
			
			init();
			out.println(solve());;
			
			in.close();
			out.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	static void init() {
		n = in.nextInt();
		arr = new int[n];
		thr = new int[n*n*n];
		two = new int[n*n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int ct = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					thr[ct] += arr[i]*100+arr[j]*10+arr[k];
					ct++;
				}
			}
		}
		int cut = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) { 
				two[cut] += arr[i]*10+arr[j];
				cut++;
			}
		}
	}
	static int solve() {
		int ans = 0;
		
		for(int i = 0; i < n*n*n; i++) {
			for(int j = 0; j < n*n; j++) {
				String p1 = Integer.toString(thr[i]*Integer.parseInt(Integer.toString(two[j]).substring(1)));
				String p2 = Integer.toString(thr[i]*Integer.parseInt(Integer.toString(two[j]).substring(0,1)));
				
				if(p1.length() == 3 && p2.length() == 3) {
					if(tf(p1) == true && tf(p2) == true) {
						String a = Integer.toString(thr[i] * two[j]);
						if(tf(a) == true) ans++;
					}
				}
			}
		}
		
		return ans;
	}
	static boolean tf(String o) {
		if(o.length() == 3) {
			boolean fr = false;
			boolean tw = false;
			boolean tr = false;
			
			for(int i = 0; i < n; i++) {
				if((o.charAt(0)+"").equals(Integer.toString(arr[i]))) fr = true;
				if((o.charAt(1)+"").equals(Integer.toString(arr[i]))) tw = true;
				if((o.charAt(2)+"").equals(Integer.toString(arr[i]))) tr = true;
			}
			
			if(fr == true && tw == true && tr == true) {
				return true;
			}
			return false;
		}
		else {
			boolean fr = false;
			boolean tw = false;
			boolean tr = false;
			boolean fo = false;
			
			for(int i = 0; i < n; i++) {
				if((o.charAt(0)+"").equals(Integer.toString(arr[i]))) fr = true;
				if((o.charAt(1)+"").equals(Integer.toString(arr[i]))) tw = true;
				if((o.charAt(2)+"").equals(Integer.toString(arr[i]))) tr = true;
				if((o.charAt(3)+"").equals(Integer.toString(arr[i]))) fo = true;
			}
			
			if(fr == true && tw == true && tr == true && fo == true) {
				return true;
			}
			return false;
		}
	}

}
