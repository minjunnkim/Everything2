package _18_December;

import java.util.*;
import java.io.*;

public class mixmilk {
	
	static int m1, m2, m3, arr[], temp[];
	static Scanner in;
	static PrintWriter out;
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("mixmilk.in"));
			out = new PrintWriter(new File("mixmilk.out"));
			
			init();
			solve();
			
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	static void init() {
		arr = new int[3];
		temp = new int[3];
		temp[0] = in.nextInt();
		arr[0] = in.nextInt();
		temp[1] = in.nextInt();
		arr[1] = in.nextInt();
		temp[2] = in.nextInt();
		arr[2] = in.nextInt();
	}
	static void solve() {
		for(int i = 0; i < 100; i++) {
			m(0, 1);
			i++;
			if(i == 100) break;
			m(1, 2);
			i++;
			if(i == 100) break;
			m(2, 0);
		}
		for(int i = 0; i < 3; i++) {
			out.println(arr[i]);
		}
		
	}
	static void m(int a, int b) {
		if(arr[a] + arr[b] > temp[b]) { 
			arr[a] -= temp[b]-arr[b];
			arr[b] += temp[b]-arr[b];
		}
		else {
			arr[b] += arr[a];
			arr[a] = 0;
		}
	}

}
