import java.util.*;
import java.io.*;

public class Intermediate2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextLine()) {
			String str = in.nextLine();
			
			if(str.length() > 1) {
				int fret = Integer.parseInt(str.substring(0,str.length()-2));
				char os = str.charAt(str.length()-1);
				
				System.out.println(nextNote(fret, os));
				
			}
			else {
				char os = str.charAt(str.length()-1);
				System.out.println(fOs(os));
			}
		}

	}
	
	static char nextNote(int f, char os) {
		if(f == 12) return os;
		if(((f == 3 || f == 4) && os == 'E') || ((f == 10 || f == 11) && os == 'A')) return 'A';

		if(((f == 5 || f == 6) && os == 'E') || ((f == 0 || f == 1) && os == 'A')) return 'B';

		if(((f == 7) && os == 'E') || ((f == 2) && os == 'A')) return 'C';

		if(((f == 8 || f == 9) && os == 'E') || ((f == 3 || f == 4) && os == 'A')) return 'D';

		if(((f == 10 || f == 11) && os == 'E') || ((f == 5 || f == 6) && os == 'A')) return 'E';

		if(((f == 0) && os == 'E') || ((f == 7) && os == 'A')) return 'F';

		if(((f == 1 || f == 2) && os == 'E') || ((f == 8 || f == 9) && os == 'A')) return 'G';
		
		return '0';
	}
	
	static String fOs(char os) {
		if(os == 'A') return "5 E 12 A";
		if(os == 'B') return "7 E 2 A";
		if(os == 'C') return "8 E 3 A";
		if(os == 'D') return "10 E 5 A";
		if(os == 'E') return "12 E 7 A";
		if(os == 'F') return "2 E 8 A";
		if(os == 'G') return "3 E 10 A";
		return "0";
	}
	
}


