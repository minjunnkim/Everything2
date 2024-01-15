import java.util.*;
import java.io.*;

public class SubarraySumsII {

	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	public static void main(String[] args) {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			long a = 0;
			long ans = 0;
			long[] p = new long[n+1];
			Map<Long, Integer> sum = new HashMap<Long, Integer>();
			sum.put((long)0,0);
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= n; i++) {
				p[i] = p[i-1]+Long.parseLong(st.nextToken());
				sum.put(p[i],0);
				
			}
			
			System.out.println(Arrays.toString(p));
			
			for(int i = 0; i <= n; i++) {
				a = (x-p[i])*-1;
				sum.put(p[i], sum.get(p[i])+1);
				
				if(sum.containsKey(a)) {
					ans+=sum.get(a);
				}
			}
			
			System.out.println(sum.toString());
			
			System.out.println(ans);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
