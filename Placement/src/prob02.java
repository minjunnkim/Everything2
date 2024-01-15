import java.util.*;
import java.io.*;

public class prob02 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	
		int h = in.nextInt();
		int m = in.nextInt();
		int s = in.nextInt();
		
		
		if(h*s >= m) System.out.println(h + " " + m + " " + s + ". I will make it!");
		else  System.out.println(h + " " + m + " " + s + ". I will be late!");
	}

}
