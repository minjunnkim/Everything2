import java.util.*;
import java.io.*;

public class where {

	public static int[] dx = {-1,0,0,1};
	public static int[] dy = {0,-1,1,0};

	public static int n;
	public static char[][] grid;

	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(new File("where.in"));
		PrintWriter out = new PrintWriter(new FileWriter("where.out"));
		
		n = in.nextInt();
		grid = new char[n][];
		for (int i=0; i<n; i++)
			grid[i] = in.next().toCharArray();

		ArrayList<Integer> all = new ArrayList<Integer>();
		for (int r1=0; r1<n; r1++)
			for (int r2=r1+1; r2<=n; r2++)
				for (int c1=0; c1<n; c1++)
					for (int c2=c1+1; c2<=n; c2++)
						if (valid(r1,r2,c1,c2))
							all.add(1000000*r1+10000*r2+100*c1+c2);
		int res = 0;
		for (int i=0; i<all.size(); i++) {
			boolean ok = true;
			for (int j=0; j<all.size(); j++) {
				if (j == i) continue;
				if (dominates(all.get(j), all.get(i))) {
					ok = false;
					break;
				}
			}
			if (ok) res++;
		}

		
		out.println(res);
		out.close();
		in.close();
	}

	public static boolean dominates(int op1, int op2) {
		int[] dim1 = get(op1);
		int[] dim2 = get(op2);
		return dim1[0] <= dim2[0] && dim1[1] >= dim2[1] && dim1[2] <= dim2[2] && dim1[3] >= dim2[3];
	}

	public static int[] get(int code) {
		int[] res = new int[4];
		res[0] = code/1000000;
		res[1] = (code/10000)%100;
		res[2] = (code/100)%100;
		res[3] = code%100;
		return res;
	}


	public static boolean valid(int r1, int r2, int c1, int c2) {

		boolean[] used = new boolean[26];
		int cnt = 0;
		for (int i=r1; i<r2; i++) {
			for (int j=c1; j<c2; j++) {
				if (!used[grid[i][j]-'A']) {
					used[grid[i][j]-'A'] = true;
					cnt++;
				}
			}
		}
		if (cnt != 2) return false;

		boolean[][] filled = new boolean[n][n];

		char done = '!';
		int numF = 0;

		for (int i=r1; i<r2; i++) {
			for (int j=c1; j<c2; j++) {
				
				if (numF == 2) break;

				if (filled[i][j]) continue;

				if (grid[i][j] != done) {
					floodfill(i, j, grid[i][j], r1, r2, c1, c2, filled);
					numF++;
				}
			}
			if (numF == 2) break;
		}

		used = new boolean[26];
		cnt = 0;

		for (int i=r1; i<r2; i++) {
			for (int j=c1; j<c2; j++) {

				if (!filled[i][j] && !used[grid[i][j]-'A']) {
					used[grid[i][j]-'A'] = true;
					cnt++;
				}
			}
		}

		return cnt == 1;
	}

	public static void floodfill(int x, int y, char c, int r1, int r2, int c1, int c2, boolean[][] filled) {

		if (x < r1 || x >= r2) return;
		if (y < c1 || y >= c2) return;

		if (grid[x][y] != c || filled[x][y]) return;

		filled[x][y] = true;

		for (int i=0; i<dx.length; i++)
			floodfill(x+dx[i], y+dy[i], c, r1, r2, c1, c2, filled);
	}
}