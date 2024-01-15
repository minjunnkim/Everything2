import java.io.*;
import java.util.*;

public class cowntagion {
	
	static int n, count, min;
	static int[] cowvid;
	static ArrayList<Integer> roads;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		cowvid = new int[n];
		cowvid[0] = 1;
		for(int i = 1; i < n; i++) {
			cowvid[i] = 0;
		}
		
		boolean allOne = true;
		
		roads = new ArrayList<Integer>();
		for(int i = 0; i < n-1; i++) {
			int temp = in.nextInt();
			int temp2 = in.nextInt();
			if(temp != 1 && temp2 != 1) allOne = false;
			roads.add(temp);
			roads.add(temp2);
		}
		count = 0;
		if(allOne == true) { 
			while(cowvid[0] < n) superspread(1);
			count += n-1;
			
		}
		else {
			
			min = 100000000;
			
			while(check(cowvid) == false) {
				count = 0;
				
				
				
				if(count < min) min = count;
			}
		
		}
		
		System.out.println(count);
		
	}
	public static boolean check(int[] cowvid) {
		for(int b : cowvid) {
			if(b == 0) return false;
		}
		return true;
	}
	
	static void superspread(int farmNum) {
		cowvid[farmNum-1] *= 2;
		count++;
	}
	
	static void move(int farmNum, int moveNum) {
		cowvid[farmNum] -= 1;
		cowvid[moveNum] += 1;
		count++;
	}

}
