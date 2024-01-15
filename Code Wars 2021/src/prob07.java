import java.util.*;
import java.io.*;

class prob07 {

	static Scanner in;
	static String s1, s2, out, out1;
	static double n, ans;;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("input.txt"));
			
			init();
			solve();
			System.out.println(out1 + " " + out);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	static void init() {
		s1 = in.next();
		s2 = in.next();
		out = "";
		out1 = "";
		
		n = 0.0;
		ans = 0.0;
	}
	
	static void solve() {
		if(s1.equals("RUBBER")) {
			if(s2.equals("CONCRETE")) n = 0.90;
			else if(s2.equals("WOOD")) n = 0.80;
			else if(s2.equals("STEEL")) n = 0.70;
			else if(s2.equals("RUBBER")) n = 1.15;
			else if(s2.equals("ICE")) n = 0.15;
			
		}
		
		else if(s1.equals("WOOD")) {
			if(s2.equals("CONCRETE")) n = 0.62;
			else if(s2.equals("WOOD")) n = 0.42;
			else if(s2.equals("STEEL")) n = 0.30;
			else if(s2.equals("RUBBER")) n = 0.80;
			else if(s2.equals("ICE")) n = 0.05;
			
		}
		
		else if(s1.equals("STEEL")) {
			if(s2.equals("CONCRETE")) n = 0.57;
			else if(s2.equals("WOOD")) n = 0.30;
			else if(s2.equals("STEEL")) n = 0.74;
			else if(s2.equals("RUBBER")) n = 0.70;
			else if(s2.equals("ICE")) n = 0.03;
			
		}
		
		ans = Math.atan(n)*(180/Math.PI);
		
		out1 = String.format("%.2f", n);
		out = String.format("%.1f", ans);
		
		
	}

}
