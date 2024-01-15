import java.util.*;
import java.io.*;

public class div7 {

	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	static BufferedWriter bw;
	
	public static void main(String[] args) {
		try {
			br = new BufferedReader(new FileReader("bcount.in"));
			bw = new BufferedWriter(new FileWriter("bcount.out"));
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			
			int n = st.nextToken();
			
			
			
			bw.write(sb.toString());
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
