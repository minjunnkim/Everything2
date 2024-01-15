import java.util.*;
import java.io.*;

public class test {

	public static void main(String[] args) {
		int t = 0;
		for(int j = 1; j <= 5; j++) {
			for(int k = 1; k <= 5; k++) {
				for(int m = 1; m <= 5; m++) {
					if(j*j + k*k == m*m) t = t+1;
					System.out.println(j*j+k*k + " " + m*m  + " " + t);
				}
			}
		}
		
		System.out.println(t/2);
		
	}

}
