import java.util.*;
import java.io.*;

public class bcount {

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
			
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int[] prefix1 = new int[N+1];
			int[] prefix2 = new int[N+1];
			int[] prefix3 = new int[N+1];
			
			for(int i = 1; i <= N; i++) {
				int t = Integer.parseInt(br.readLine());
				
				prefix1[i] = prefix1[i-1];
				prefix2[i] = prefix2[i-1];
				prefix3[i] = prefix3[i-1];
				
				if(t == 1) prefix1[i]++;
				else if(t == 2) prefix2[i]++;
				else prefix3[i]++;
			}
			
			for(int i = 0; i < Q; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken())-1;
				int e = Integer.parseInt(st.nextToken());
				
				int a = prefix1[e]-prefix1[s];
				int b = prefix2[e]-prefix2[s]; 
				int c = prefix3[e]-prefix3[s];
				sb.append(a).append(" ").append(b).append(" ").append(c).append("\n");
				
			}
			
			bw.write(sb.toString());
			
			br.close();
			bw.close();
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
