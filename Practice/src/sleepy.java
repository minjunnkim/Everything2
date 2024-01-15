import java.util.*;
import java.io.*;

public class sleepy {
	
	static Scanner in;
	static PrintWriter out;
	static int n;
	static int[] input;
	
	public static void main(String[] args) {
		try { 
			in = new Scanner(new File("sleepy.in"));
			out = new PrintWriter(new File("sleepy.out"));
			
			init();
			out.print(solve());
			
			in.close();
			out.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void init() {
		n = in.nextInt();
		input = new int[n];
		for(int i = 0 ; i < n; i++) {
			input[i] = in.nextInt();
		}
	}
	private static int solve() {
		int ans = 0;
		for(int i = n-1; i > 0; i--) {
			if(input[i-1] > input[i]) {
				ans = i;
				break;
			}
		}
		return ans;
		
	}

}
