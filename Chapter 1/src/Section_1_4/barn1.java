/*
ID: ckandre1
LANG: JAVA
TASK: barn1
 */
package Section_1_4;

import java.util.*;
import java.io.*;

public class barn1 {
	
	static int m, s, c, temp[];
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static Scanner in;
	static PrintWriter out;
	static int result;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("barn1.in"));
			out = new PrintWriter(new File("barn1.out"));
			
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
		m = in.nextInt();
		s = in.nextInt();
		c = in.nextInt();
		temp = new int[c];
	}
	static int solve() {
		if(m>c) {
			return c;
		}
		for(int i = 0; i < c; i++) {
			temp[i] = in.nextInt();
		}
		Arrays.sort(temp);
		for(int i = 1; i < temp.length; i++) {
			list.add(temp[i]-temp[i-1]-1);
		}
		
		Collections.sort(list,  Collections.reverseOrder());
		
		result = temp[temp.length-1] - temp[0] +1;
		
		for(int i = 0; i < m-1; i++) {
			result = result-list.get(i);
		}
		
		return result;
	}

}
