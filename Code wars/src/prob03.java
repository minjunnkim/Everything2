import java.util.Scanner;
import java.io.*;

public class prob03 {
	static Scanner in;
	static int x, y;
	public static void main(String[] args) {
	   try {
		   in = new Scanner(new File("prob03-3-in.txt"));
		   
		   init();
		   System.out.println(GCF(x, y));
		   
		   in.close();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
  }
   
  public static void init() {
	 x = in.nextInt();
	 y = in.nextInt();
	
  }
  public static int GCF(int a, int b) { 
	  if (b == 0) { 
		  return a; 
		  } 
	  else { 
		  return (GCF(b, a % b)); 
	  } 
  }
  
}  