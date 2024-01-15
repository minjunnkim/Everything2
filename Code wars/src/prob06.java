import java.util.*;
import java.io.*;

public class prob06 {
	static Scanner in;
	static ArrayList<String> arr;
	static ArrayList<String> ans;
	static Map<Integer, String> key = new HashMap<Integer, String>();
	public static void main(String[] args) {
	   try {
		   in = new Scanner(new File("input.txt"));
		   
		   init();
		   solve();
		   for(int i = 0; i < ans.size(); i++) {
			   System.out.println(ans.get(i));
		   }
		   
		   in.close();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
  }
   
  public static void init() {
	 arr = new ArrayList<String>();
	 ans = new ArrayList<String>();
	 while(in.hasNextLine()) {
		 arr.add(in.nextLine());
	 }
	 key.put(1, "B"); key.put(2, "BB"); key.put(3, "BBB"); key.put(4, "BW"); key.put(5, "W"); key.put(6, "WB"); key.put(7, "WBB"); key.put(8, "WBBB"); key.put(9, "BK"); key.put(10, "Z"); key.put(20, "ZZ"); key.put(30, "ZZZ"); key.put(40, "ZP"); key.put(50, "P"); key.put(60, "PZ"); key.put(70, "PZZ"); key.put(80, "PZZZ"); key.put(90, "ZB"); key.put(100, "B"); key.put(200, "BB"); key.put(300, "BBB"); key.put(400, "BG"); key.put(500, "G"); key.put(600, "GB"); key.put(700, "GBB"); key.put(800, "GBBB"); key.put(900, "BR"); key.put(1000, "R");  
	 
  }
  public static void solve() { 
	  for(int i = 0; i < arr.size(); i++) {
		  String answer = "";
		  int temp = arr.get(i).length();
		  int count = temp;
		  for(int j = 0; j < temp; j++) {
			  int a = (int) (Character.getNumericValue(arr.get(i).charAt(j)) * Math.pow(10, count-1));
			  if(a == 0) continue;
			  answer += key.get(a);
			  count--;
		  }
		  ans.add(answer);
	  }
  }
  
}  