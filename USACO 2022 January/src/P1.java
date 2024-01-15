import java.util.*;
import java.io.*;

public class P1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long a = 0;
		long b = 0;
		long n = Long.parseLong(br.readLine());
		
		for(long i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			System.out.println(f(a,b));
		}
		
		
	}
	
	static long f(long a, long b) {
		if(a==b) return 0;
		if(a > b) {
			long odd = a%2;
			return 1+odd+f((a+odd)/2, b);
		}
		else {
			long odd = b%2;
			return Math.min(1+odd+f(a,(b-odd)/2), b-a);
		}
			
	}

}
