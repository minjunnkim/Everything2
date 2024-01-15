import java.util.*;
import java.io.*;

class prob18 {

	static Scanner in;
	static String name;
	static int ppl, time, startup, pplA;
	static double power;
	
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("input.txt"));
			
			init();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	static void init() {
		name = in.nextLine();
		ppl = in.nextInt();
		time = in.nextInt()*60;
		startup = in.nextInt();
		power = in.nextDouble();
		pplA = in.nextInt();
		
		if(startup > time || pplA < ppl) {
			System.out.println(name + " can generate 0.00 watts/second ");
			System.out.println("WHOA, HEAVY!");
		}
		else {
			power /= 3600;
			if(power >= 1210000000.00) {
				System.out.println(name + " can generate " + String.format("%.2f", power) + " watts/second");
				System.out.println("MARTY CAN MAKE IT!");
			}
			else {
				System.out.println(name + " can generate " + String.format("%.2f", power) + " watts/second");
				System.out.println("WHOA, HEAVY!");
			}
		}
		
	}

}
