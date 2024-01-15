package _17_December;
import java.util.*;
import java.io.*;

public class shell {
	
	static Scanner in;
	static PrintWriter out;
	static int n;
	static int[] grid, swap, guess, count;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("shell.in"));
			out = new PrintWriter(new File("shell.out"));
			
			init();
			out.println(solve());
			
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void init() {
		n = in.nextInt();
		in.nextLine();
		count = new int[3];
		grid = new int[3];
		swap = new int[n*2];
		guess = new int[n];
		int temp = 0;
		for(int i = 0; i < n*2; i+=2) {
			swap[i] = in.nextInt();
			swap[i+1] = in.nextInt();
			guess[temp] = in.nextInt();
			temp++;
		}
	}
	private static int solve() {
		
		for(int i = 0; i < 3; i++) {
			grid[0] = 0; grid[1] = 0; grid[2] = 0;
			grid[i] = 1;
			
			int t = 0;
			for(int j = 0; j < n*2; j+=2) {
				int temp = grid[swap[j]-1];
				grid[swap[j]-1] = grid[swap[j+1]-1]; grid[swap[j+1]-1] = temp;
				if(grid[guess[t]-1] == 1) count[i]++;
				t++;
			} 
		}
		return Math.max(count[0], Math.max(count[1], count[2]));
	}

}
