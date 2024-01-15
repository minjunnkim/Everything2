import java.util.*;
import java.io.*;

class prob15 {

	static Scanner in;
	static double ans;
	
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("input.txt"));
			
			init();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	static void init() {
		String[] start = in.next().split(":");
		String[] call = in.next().split(":");
		
		int s = (Integer.parseInt(start[0])*60 + Integer.parseInt(start[1]))*60 + Integer.parseInt(start[2]);
		int e = (Integer.parseInt(call[0])*60 + Integer.parseInt(call[1]))*60 + Integer.parseInt(call[2]) + 40;
		
		int end = 500-(e-s);
		if(end < 0) System.out.println("0.00");
		else System.out.println(String.format("%.2f",(double)(end)/100));
		
		
		for(int j = 0; j < 6; j++) {
			System.out.print("|");
			for(int i = 0; i < end/20; i++) {
				if(j == 5) System.out.print(".");
				else System.out.print(" ");
			}
			System.out.print("|");
			System.out.println(" ");
		}
		
		if(end < 20) System.out.println("CURSE MY METAL BODY, I WASN'T FAST ENOUGH!");
		else if(end == 20) System.out.println("THIS IS SOME RESCUE!");
		else System.out.println("THE FORCE WAS WITH YOU");
	}

}
