import java.util.*;
import java.io.*;

public class prob05 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt(); in.nextLine();
		
		String[] str = new String[n];
	
		for(int i = 0; i < n; i++) {
			str[i] = in.nextLine();
		}
		
		int count = 0;
		ArrayList<String> duplicates = new ArrayList<String>();
		for(int i = 0; i < n-1; i++) {
			for(int j = i+1; j < n; j++) {
				if(str[i].substring(0,5).equals(str[j].substring(0,5))) {
					if(!duplicates.contains(str[i].substring(0,5))) {
						count++;
						duplicates.add(str[i].substring(0,5));
					}
				}
			}
		}
		
		System.out.println(count);
		System.out.print("duplicates: ");
		
		for(int i = 0; i < duplicates.size(); i++) {
			System.out.print(duplicates.get(i) + " ");
		}
	}

}
