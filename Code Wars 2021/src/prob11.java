import java.util.*;
import java.io.*;

class prob11 {

	static Scanner in;
	static double f, k, x;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("input.txt"));
			
			solve();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	static void solve() {
		f = 0;
		k = 0;
		x = 0;
		
		int options = 0;
		for(int i = 0 ; i < 3; i++) {
			String[] input = in.nextLine().split(" ");
			if(input[1].equals("?")) {
				if(i == 0) options = 1;
				else if(i == 1) options = 2;
				else if(i == 2) options = 3;
			}
			else {
				if(i == 0) f = Double.parseDouble(input[1]);
				else if(i == 1) k = Double.parseDouble(input[1]);
				else if(i == 2) x = Double.parseDouble(input[1]);
			}
		}
		
		if(options == 1) solveForF();
		else if(options == 2) solveForK();
		else solveForX();
	}
	
	static void solveForF() {
		System.out.println("F " + String.format("%.2f", -k*x));
	}
	
	static void solveForK() {
		System.out.println("K " + String.format("%.2f", -f/x));
	}
	
	static void solveForX() {
		System.out.println("X " + String.format("%.2f", -f/k));
	}
	
}
