import java.util.*;
import java.io.*;

public class maxcross {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new FileWriter("maxcross.out"));
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int[] sum = new int[n];
		Arrays.fill(sum, 1);
		
		for(int i = 0; i < b; i++) {
			sum[Integer.parseInt(br.readLine().trim())-1] = 0;
		}
		
		
		int a = 0;
		for(int i = 0; i < k; i++) {
			a += sum[i];
		}
		
		int m = a;
		
		for(int i = k; i < n; i++) {
			a += (sum[i] - sum[i-k]);
			m = Math.max(m, a);
		}
		
		pw.println(k-m);
		pw.close();
		br.close();
	}

}
