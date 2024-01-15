import java.io.*;
import java.util.*;
public class one {

	static int n, k;
	static int[] original;
	static int[] cows, ans;
	static boolean[][] visit;
	static duo[] mooves;
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		mooves = new duo[k];
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			duo temp = new duo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			mooves[i] = temp;
		}
		
		visit = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			visit[i][i] = true;
		}
		
		original = new int[n];
		cows = new int[n];
		for(int i = 1; i <= n; i++) {
			original[i-1] = i;
			cows[i-1] = i;
		}
		

		
		swap();
		while (!Arrays.equals(original, cows)) {
			swap();
		}

		ans = new int[n];

		for(int i = 0; i < n ; i++) {
			for(int j = 0; j < n; j++) {
				if(visit[i][j]) ans[i]++;
				
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(ans[i]);
		}
		
	
	
	}
	
	public static void swap() {
		for(int i = 0; i < k; i++) {
			int t1 = mooves[i].a;
			int t2 = mooves[i].b;

			int x = cows[t1-1];
			cows[t1-1] = cows[t2-1];
			cows[t2-1] = x;

			visit[cows[t1-1]-1][t1-1] = true;
			visit[cows[t2-1]-1][t2-1] = true;




			if(Arrays.equals(original, cows)) return;
		}
	}
}
		


class duo implements Comparable<duo> {

	public int a;
	public int b;
	
	public duo(int one, int two){
		a = one;
		b = two;
	}
	
	public int compareTo(duo arg0) {
		return 0;
	}
	
}


