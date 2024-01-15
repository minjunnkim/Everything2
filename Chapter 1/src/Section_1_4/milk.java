/*
ID: ckandre1
LANG: JAVA
TASK: milk
 */
package Section_1_4;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class milk {
	
	static int req, n;
	static int[] k;
	static TreeMap<Integer, Integer> farmer;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("milk.in"));
			out = new PrintWriter(new File("milk.out"));
			
			init();
			out.println(solve());
			
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	static void init() {
		req = in.nextInt();
		n = in.nextInt(); 
		in.nextLine();
		
		farmer = new TreeMap<Integer, Integer>();
		for(int i = 0; i < n; i++) {
			int f = in.nextInt();
			if(farmer.containsKey(f)) farmer.put(f, farmer.get(f) + in.nextInt());
			
			else farmer.put(f, in.nextInt()); 

		}
	}
	static int solve() {
		int ans = 0;
		k = new int[farmer.size()];
		int i = 0;
		for(int r : farmer.keySet()) {
			k[i] = r; 
			i++;
		}
		int total = 0;
		for(int j = 0; j < n; j++) {
			for(int h = 0; h < farmer.get(k[j]); h++) {
				ans += k[j];
				total++;
				if(total == req) break;
				
			}
			if(total == req) break;
		}
		return ans;
	}

}
