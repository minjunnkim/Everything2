import java.util.*;
import java.io.*;

class prob10 {

	static Scanner in;
	static ArrayList<String> tasty;
	
	
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
		tasty = new ArrayList<String>();
		ArrayList<String> villagers = new ArrayList<String>();
		ArrayList<Integer> times = new ArrayList<Integer>();
		ArrayList<Integer> VPF = new ArrayList<Integer>();
		
		while(1==1) {
			String next = in.nextLine();
			if(next.equals("END")) {
				break;
			}
			String[] input = next.split(" ");
			
			villagers.add(input[0].substring(9));
			
			String[] time = input[1].split(":");
			times.add(Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]));
			
			VPF.add(Integer.parseInt(input[2]));
		}
		
		for(int i = 0; i < villagers.size(); i++) {
			if(times.get(i) + VPF.get(i)*10 < 1020) tasty.add(villagers.get(i));
		}
		
		if(tasty.size() == 0) System.out.println("Blah, blah, blah, time to order delivery");
		else {
			System.out.print("Villagers (");
			for(int i = 0; i < tasty.size(); i++) {
				if(i != tasty.size()-1)	System.out.print(tasty.get(i) + ", ");
				
				else System.out.print(tasty.get(i));
			}
			System.out.print(") look tasty");
		}
	}

}
