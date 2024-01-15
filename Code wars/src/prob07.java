import java.util.*;
import java.io.*;

public class prob07 {
	static Scanner in;
	static ArrayList<String> colors, ans;
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
	  colors = new ArrayList<String>();
	  while(in.hasNext()) {
		  colors.add(in.next());
	  }
	  
	  ans = new ArrayList<String>();
  }
  public static void solve() { 
	  for(int i = 0; i < colors.size(); i+=2) {
		  String s1 = colors.get(i);
		  String s2 = colors.get(i+1);
		  
		  if(s1.equals("WHITE") || s1.equals("BLACK")) {
			  String temp = s2;
			  s2 = s1;
			  s1 = temp;
		  }
		  
		  if(s2.equals("WHITE") || s2.equals("BLACK")) ans.add(bnw(s1, s2));
		  else ans.add(triforce(s1, s2));
	  }
  }
  
  public static String triforce(String s1, String s2) {
	  if(s1.equals(s2)) return s1;
	  else if(s1.equals("RED")) {
		  if(s2.equals("YELLOW")) return "ORANGE";
		  else return "PURPLE";
	  }
	  else if(s1.equals("YELLOW")) {
		  if(s2.equals("BLUE")) return "GREEN";
		  else return "ORANGE";
	  }
	  else if(s1.equals("BLUE")) {
		  if(s2.equals("YELLOW")) return "GREEN";
		  else return "PURPLE";
	  }
	  return s1;	
  }
  
  public static String bnw(String s1, String s2) {
	  if(s1.equals(s2)) return s1;
	  else if(s2.equals("WHITE")) return "LIGHT " + s1;
	  else return "DARK " + s1;
  }
  
}  