import java.util.*;
import java.io.*;

public class Intermediate1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		int n = in.nextInt();
		
		System.out.print(a + "," + b);
		for(int i = 0; i < n-2; i++) {
			System.out.print("," + (a+b));
			int temp = a;
			a = b;
			b = temp+a;
		}
	}

}
