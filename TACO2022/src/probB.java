import java.util.*;
import java.io.*;


public class probB {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	
		char[] arr = in.nextLine().toCharArray();
		
		int s = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == '0' || arr[i] == '2' || arr[i] == '4' || arr[i] == '8' || arr[i] == '6' || arr[i] == '7') {
				s = i;
				break;
			}
		}
		
		if(arr[s] == '0' || arr[s] == '2' || arr[s] == '4' || arr[s] == '8') { 
			arr[s]++;
			for(int i = s+1; i < arr.length; i++) {
				arr[i] = '1';
				//if(arr[i] == '0' || arr[i] == '2' || arr[i] == '4'|| arr[i] == '6' || arr[i] == '7' || arr[i] == '8') arr[i] = '1';
			}
		}
		else if(arr[s] == '6' || arr[s] == '7') {
			arr[s] = '9';
			for(int i = s+1; i < arr.length; i++) {
				arr[i] = '1';
				//if(arr[i] == '0' || arr[i] == '2' || arr[i] == '4'|| arr[i] == '6' || arr[i] == '7' || arr[i] == '8') arr[i] = '1';
			}
		}
		
		
		
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		
	}

}
