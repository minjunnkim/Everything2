package _20_January;
/*
ID: ckandrew
TASK: word
LANG: java
 */
import java.util.*;
import java.io.*;

public class word {

	static Scanner in;
	static PrintWriter out;
	static String[] str;
	static ArrayList<String> strar;
	static int n, k;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("word.in"));
			out = new PrintWriter(new File("word.out"));
			
			init();
			solve();
			
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		n = in.nextInt();
		k = in.nextInt();
		in.nextLine();
		
		str = in.nextLine().split(" ");
		strar = new ArrayList<String>();
		
		//System.out.println(n + " " + k + " " + Arrays.toString(arr));
	}
	
	private static void solve() {
		int l = str[0].length();

		String line = str[0];
		for(int i = 1; i < n; i++) {
			int temp = str[i].length();
			
			//System.out.println(temp + " " + line + " " + l);
			
			if(l+temp <= k) { //if word fits, add to the line
				l += temp;
				line += " " + str[i];
				if(i == n-1) {
					out.println(line);
				}
			}
			else { //if word doesn't fit, next line and print
				out.println(line);
				line = str[i];
				l = temp;
				if(i == n-1) {
					out.println(line);
				}
			}
			
		}
	}

}
