package _20_January;
/*
ID: ckandrew
TASK: photo
LANG: java
 */

import java.util.*;
import java.io.*;

public class photo {

	static Scanner in;
	static PrintWriter out;
	static int n;
	static int[] b, a;
	
	public static void main(String[] args) {
		try {

			in = new Scanner(new File("photo.in"));
			out = new PrintWriter(new File("photo.out"));
			
			init();
			solve();
			
			in.close();
			out.close();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void init() {
		n = in.nextInt();
		
		b = new int[n-1];
		a = new int[n];
		for(int i = 0; i < n-1; i++) {
			b[i] = in.nextInt();
		}
	}
	
	private static void solve() {
		for(int i = 1; i < b[0]; i++) {
			ArrayList<Integer> already = new ArrayList<Integer>();
			already.add(i);
			a[0] = i;
			int temp = i;
			int count = 0;
			for(int j = 0; j < n-1; j++) {
				a[j+1] = b[j]-temp;
				temp = a[j+1];

				if(already.contains(temp) || temp <= 0) {
					count++;
				}
				already.add(temp);
				
			}
			if(count == 0) break;
		}
		
		for(int i = 0; i < n; i++) {
			if(i == n-1) out.println(a[i]);
			else out.print(a[i] + " ");
		}
	}
}
