import java.util.*;
import java.io.*;

public class oneFeb {

	static Scanner in;
	static int n;
	static int[][] pasture;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(System.in);
			
			init();
			solve();
			
			
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	static void init() {
		n = in.nextInt();
		
		pasture = new int[1000][1000];
		
	}
	
	static void solve() {
		for(int i = 0; i < n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			newCow(x, y);
			
			int count = 0;
			int maxX = 0;
			int maxY = 0;
			if(x > maxX) maxX = x;
			if(y > maxY) maxY = y;
			
			for(int j = 0; j < (maxX+1)*2; j++) {
				for(int k = 0; k < (maxY+1)*2; k++) {
					if(pasture[j][k] == 4) {
						int[] coord = direction(j, k);
						newCow(coord[0], coord[1]);
						if(pasture[coord[0]-1][coord[1]] == 4) {
							newCow(coord[0]-1, coord[1]);
							count++;
						}
						if(pasture[coord[0]+1][coord[1]] == 4) {
							newCow(coord[0]-1, coord[1]);
							count++;
						}
						if(pasture[coord[0]][coord[1]-1] == 4) {
							newCow(coord[0]-1, coord[1]);
							count++;
						}
						if(pasture[coord[0]][coord[1]+1] == 4) {
							newCow(coord[0]-1, coord[1]);
							count++;
						}
						count++;
					}
				}
			}
			
			System.out.println(count);
			
			
		}
	}
	static int[] direction(int x, int y) {
		int[] coord = new int[2];
		
		if(pasture[x-1][y] >= 1) {
			coord[0] = x-1;
			coord[1] = y;
		}
		else if(pasture[x+1][y] >= 1) {
			coord[0] = x+1;
			coord[1] = y;
		}
		else if(pasture[x][y-1] >= 1) {
			coord[0] = x;
			coord[1] = y-1;
		}
		else {
			coord[0] = x;
			coord[1] = y+1;
		}
		
		return coord;
	}
	
	static void newCow(int x, int y) {
		if(pasture[x][y] >= 1) return;
		int count = 1;
		if(x != 0) {
			if(pasture[x-1][y] >= 1) {
				count++; 
				pasture[x-1][y]++;
			}
		}
		if(pasture[x+1][y] >= 1) {
			count++; 
			pasture[x+1][y]++;
		}
		if(pasture[x][y+1] >= 1) {
			count++; 
			pasture[x][y+1]++;
		}
		
		if(y != 0) {
			if(pasture[x][y-1] >= 1) {
				count++; 
				pasture[x][y-1]++;
			}
		}
		pasture[x][y] = count;
		
		
	}

}
