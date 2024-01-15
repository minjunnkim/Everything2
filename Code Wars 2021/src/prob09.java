import java.util.*;
import java.io.*;

class prob09 {

	static Scanner in;
	static double minicount, pit, bodyH, bodyR, wingL, wingW, wingH;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("input.txt"));
			
			init();
			solve();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	static void init() {
		minicount = in.nextDouble();
		pit = in.nextDouble();
		bodyR = in.nextDouble();
		bodyH = in.nextDouble();
		wingL = in.nextDouble();
		wingW = in.nextDouble();
		wingH = in.nextDouble();
	}
	
	static void solve() {
		double cp = ((double)4/3) * Math.PI * Math.pow(pit, 3) - 2.2 - 4.1;
		String cockpit = String.format("%.2f", cp	);
		System.out.println("Cockpit " + cockpit);
		
		double b = bodyH* Math.PI * Math.pow(bodyR, 2) - 12.1;
		String body = String.format("%.2f", b);
		System.out.println("Body " + body);
		
		double p = ((double)1/3) *  wingL*wingW*wingH*2;
		String pods = String.format("%.2f", p);
		System.out.println("Pods " + pods);
		
		double need = minicount*1.2;
		String minionsNeed = String.format("%.2f", need);
		System.out.println("Minions Need " + minionsNeed);
		
		double minions = Double.parseDouble(String.format("%.2f", need));
		double space = Double.parseDouble(String.format("%.2f", cp+b+p));
		if(minions <= space) System.out.println("PLAN ACCEPTED");
		else System.out.println("PLAN REJECTED");
		
		
	}

}
