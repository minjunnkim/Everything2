package _20_January;
/*
ID: ckandrew
TASK: race
LANG: java
 */

import java.io.*;
import java.util.*;
public class race {
	
	static Scanner in;
	static PrintWriter out;
	static int k, n;
	static int[] x, ans;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("race.in"));
		out = new PrintWriter(new File("race.out"));

		init();
		solve();
		
		in.close();
		out.close();
	}
	
	private static void init() {
		k = in.nextInt();
		n = in.nextInt();
		x = new int[n];
		ans = new int[n];
		
		for(int i = 0; i < n; i++) {
			x[i] = in.nextInt();
		}
	}
	
	private static void solve() {
		for(int i = 0; i < n; i++) {
			int temp = x[i];
			
			ArrayList<Integer> arr = new ArrayList<Integer>();
			
			int dist = 1+temp;
			int current = 1;
			arr.add(1);
			while(dist < k) {
				if(current < temp) {
					current++;
					arr.add(current);
					dist+=current;
				}
				else {
					current++;
					arr.add(current);
					dist+=current;
					if(dist < k) {
						arr.add(current);
						dist += current;
					}
					
				}
				
			}

			arr.add(temp);
			
			ans[i] = arr.size();
			
		}
		
		for(int i = 0; i < n; i++) {
			out.println(ans[i]);
		}
		
	}

}
