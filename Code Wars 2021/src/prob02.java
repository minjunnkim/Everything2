import java.util.*;
import java.io.*;

public class prob02 {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		double height = in.nextDouble();
		double radius = in.nextDouble();
		
		double volume =  Math.PI * radius * radius * height;
		
		System.out.printf("%.2f cubic inches", volume);
	}

}
