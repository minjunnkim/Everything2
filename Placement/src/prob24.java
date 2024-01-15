import java.util.*;
import java.io.*;

public class prob24 {

	static char[] table;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		char[] c = in.nextLine().toCharArray();
		table = in.nextLine().toCharArray();
		
		String total = "";
		for(int i = 0; i < c.length; i++) {
			int temp = charIndexOf(c[i]) - 8;
			
            String result= "000000";
            int j=result.length()-1;
            while(temp!=0)
            {
              char a[]=result.toCharArray();
              a[j--]= String.valueOf(temp%2).charAt(0);
              result=new String(a);
              temp=temp/2;  

            }
            //System.out.println(result);
            total += result;
		}
		
		
		//System.out.println(total);
		String ans = "";
		for(int i = 0; i < total.length(); i+=8) {
			char temp = (char) Integer.parseInt(total.substring(i, i+8), 2);
			ans += temp;
		}
		
		System.out.println(ans);
	}
	
	static int charIndexOf(char c) {
		int found = -1;
		for (int i = 0; i < table.length; ++i) {
		  if (table[i] == c) {
		    found = i;
		    break;
		  }
		}
		
		return found;
	}
	

}
