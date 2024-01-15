
import java.util.*;
import java.io.*;

public class stuck_in_a_rut {

	static ArrayList<Integer> coord;
	static int[][] visited;
	static String[] direction;
	static int[] ans;
	static int n;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		in.nextLine();
		coord = new ArrayList<Integer>();
		ans = new int[n];
		visited = new int[500][500];
		direction = new String[n];
		
		for(int i = 0; i < n; i++) {
			String input = in.nextLine();
			String temp = input.substring(0,1);
			String[] t = input.substring(2).split(" ");
			int x = Integer.parseInt(t[0]);
			int y = Integer.parseInt(t[1]);
			direction[i] = temp;
			coord.add(Integer.parseInt(t[0]));
			coord.add(Integer.parseInt(t[1]));
			
			visited[x][y] = 1;
		}
		
		for(int i = 0; i < 500; i++) {
			for(int j = 0; j < coord.size(); j++) {
				if(direction[j].equals("E")) {
					coord.set(j*2, coord.get(j*2)+1);
				}
				else {
					coord.set((j*2)+1, coord.get((j*2)+1)+1);
				}
				
				if(visited[j*2][(j*2)+1] > 0) {
					ans[visited[j*2][(j*2)+1]]++;
				}
				
				visited[j*2][(j*2)+1] = j+1;
			}
		}
		
		
		

	}

}
