/*
ID: ckandre1
LANG: JAVA
TASK: gift1
 */

package Section_1_2;

import java.util.*;
import java.io.*;

public class gift1 {

	static Scanner in;
	static PrintWriter out;
	static int n;
	static Map<String, Integer> m;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("gift1.in"));
			out = new PrintWriter(new File("gift1.out"));
			
			init();
			out.print(solve());
			
			in.close();
			out.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	static void init() {
		n = in.nextInt();
		in.nextLine();
		m = new LinkedHashMap<String, Integer>();
		for(int i = 0; i < n; i++) {
			m.put(in.nextLine(), 0);
		}
	}
	
	static String solve() {
		for(int i = 0; i < n; i++) {
			String from = in.nextLine();
			int value = in.nextInt();
			int x = in.nextInt(); in.nextLine();
			if(x == 0) continue;
			m.replace(from, m.get(from) + value%x - value);
			value = (value-value%x)/x;
			for(int j = 0; j < x; j++) {
				String who = in.nextLine();
				m.replace(who, m.get(who) + value);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(String name: m.keySet()) {
			sb.append(name).append(" ").append(m.get(name)).append("\n");
		}
		return sb.toString();
	}
	
	

}
