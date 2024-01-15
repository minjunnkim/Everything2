/*
ID: ckandre1
LANG: JAVA
TASK: beads
 */

package Section_1_2;

import java.util.*;
import java.io.*;

public class beads {

	static Scanner in;
	static PrintWriter out;
	static int n;
	static char[] beads;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("beads.in"));
			out = new PrintWriter(new File("beads.out"));
			
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
		n = in.nextInt()*2; in.nextLine();
		String str = in.nextLine();
		str += str;
		beads = str.toCharArray();
	}
	
	static int solve() {
		System.out.println(Arrays.toString(beads));
		int l = 0;
		int r = 0;
		for(int i = 0; i < n; i++) {
			int cl = 0;
			int cr = 0;
			if(beads[i] == 'w' || beads[i+1] == 'w') continue;
			else {
				int p = i;
				int k = i+1;
				char nextr = beads[i+1];
				char nextl = beads[i];
				//System.out.println(beads[i] + " " + nextl);
				while(nextl == beads[i] || nextl == 'w') {
					cl++;
					if(p == 0) break;
					p--;
					nextl = beads[p];
					//System.out.println(nextl + " " + p);
					System.out.println(beads[i] + " " + nextl);
				}
				System.out.println();
				//System.out.println(beads[i+1] + " " + nextr);
				while(nextr == beads[i+1] || nextr == 'w') {
					System.out.println(i + " " + beads[i+1] + " " + nextr);
					cr++;
					if(k == n-2) break;
					k++;
					nextr = beads[k];
					//System.out.println(nextr + " " + k);
					
				}		
//[w, w, w, b, b, r, w, r, b, r, b, r, r, b, r, b, r, w, r, w, w, r, b, w, r, w, r, r, b, w, w, w, b, b, r, w, r, b, r, b, r, r, b, r, b, r, w, r, w, w, r, b, w, r, w, r, r, b]				
			}
			System.out.println();
			System.out.println(cl + " " + cr + " " + beads[i]);
			System.out.println();
			if(cl + cr > l + r) {
				l = cl;
				r = cr;
			}
		}
		
		return l+r;
	}

}
