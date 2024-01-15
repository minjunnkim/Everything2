import java.io.*;
import java.util.*;

public class Prob00 {

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); 
		in.nextLine();
		
		for(int i = 0; i < n; i++) {
			System.out.println(in.nextLine());
		}
	}

}
