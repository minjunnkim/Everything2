
import java.util.*;
import java.io.*;

public class whereami {

	static Scanner in;
	static PrintWriter out;
	static int n;
	static String str;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("whereami.in"));
			out = new PrintWriter(new File("whereami.out"));
			
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
		str = in.nextLine();
	}
	
	private static int solve() {
		int len = 1;
		for(int y = 0; y < n; y++) {
			for(int i = 0; i < n-len+1; i++) {
				int count = 0;
				String temp = str.substring(i, i+len);
				for(int j = 0; j <= n-len; j++) {
					if(!temp.equals(str.substring(j, j+len))) {
						count++;
					}
					System.out.println(str + " " + count + " " + (n-len) +" " +   temp + " " + str.substring(j, j+len));
				}
				if(i == 0) {
					if(count == n-len) {
						return len;
					}
				}
				else if(count == n-len+1) {
					return len;
				}
			}

			len++;
		}

		return n;
	}
}
	
