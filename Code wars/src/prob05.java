import java.util.Scanner;
import java.io.*;

public class prob05 {
	static Scanner in;
	static int x, y;
	public static void main(String[] args) {
	   try {
		   in = new Scanner(new File("input.txt"));
		   
		   init();
		   solve();
		   
		   in.close();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
  }
   
  public static void init() {
	 x = in.nextInt();
  }
  public static void solve() { 
	  boolean check = false;
	  for (int i = 2; i <= x / 2; ++i) {
		  if (x % i == 0) {
			  check = true;
			  break;
		  }
	  }

	  if (!check)
		  System.out.println(x + " is PRIME");
	  else
		  System.out.println(x + " is NOT Prime");
  }
  
}  