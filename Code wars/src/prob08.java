import java.util.*;
import java.io.*;

public class prob08 {
	static Scanner in;
	static String str;
	static ArrayList<String> arr;
	static ArrayList<Integer> ind;
	public static void main(String[] args) {
	   try {
		   in = new Scanner(new File("prob08-1-in.txt"));
		   
		   init();
		   solve();
		   
		   in.close();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
  }
	
  public static void init() {
	  arr = new ArrayList<String>();
	  while(in.hasNext()) arr.add(in.next());
  }
   
  public static void solve() { 
	  int count = 0;
	  for(int i = 0; i < arr.size(); i++) {
		  count += arr.get(i).length() + 1;

		  if(count > 80) {
			  count = 0;
			  
			  ind.add(i);
		  }

	  }
  }
  
}  