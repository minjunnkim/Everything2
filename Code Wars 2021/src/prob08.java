import java.util.*;
import java.io.*;

class prob08 {

	static Scanner in;
	static int n, m, k;
	
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
		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();
	}
	
	static void solve() {
		if(n < m || m == 0 || m == 1) {
			for(int i = 0; i < n; i++) {
				System.out.println("#");
			}
			return;
		}
		int height = m-1;
		int fall = n-m+1;
		int dotCount = 0;
		
		
		
		if(k%10 == 0) {
			dotCount = (k/10)-1;
		}
		else {
			dotCount = k/10;
		}
		
		
		for(int i = 0; i < height-1; i++) {
			System.out.println("#");
		}
		
		System.out.print("#");
		for(int i = 0; i < dotCount; i++) {
			System.out.print(".");
		}
		
		for(int i = 0; i < fall; i++) {
			System.out.print("#");
		}

		
	}

}
