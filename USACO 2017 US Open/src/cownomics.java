import java.util.*;
import java.io.*;

public class cownomics {

	public static int[] code;

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new File("cownomics.in"));
		int n = in.nextInt();
		int m = in.nextInt();
		
		code = new int[26];
		code['A'-'A'] = 0;
		code['C'-'A'] = 1;
		code['G'-'A'] = 2;
		code['T'-'A'] = 3;
		
		String[] spotty = new String[n];
		for (int i=0; i<n; i++) spotty[i] = in.next();
		String[] plain = new String[n];
		for (int i=0; i<n; i++) plain[i] = in.next();

		int res = 0;
		for (int i=0; i<m; i++)
			for (int j=i+1; j<m; j++)
				for (int k=j+1; k<m; k++)
					if (counts(spotty, plain, i, j, k))
						res++;

		PrintWriter out = new PrintWriter(new FileWriter("cownomics.out"));
	
		out.println(res);
		out.close();
		in.close();
	}

	public static boolean counts(String[] list1, String[] list2, int c1, int c2, int c3) {
		boolean[] on = new boolean[64];
		for (int i=0; i<list1.length; i++)
			on[16*code[list1[i].charAt(c1)-'A']+4*code[list1[i].charAt(c2)-'A']+code[list1[i].charAt(c3)-'A']] = true;

		for (int i=0; i<list2.length; i++)
			if (on[16*code[list2[i].charAt(c1)-'A']+4*code[list2[i].charAt(c2)-'A']+code[list2[i].charAt(c3)-'A']])
				return false;
		return true;
	}
}