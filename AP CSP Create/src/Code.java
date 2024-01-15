import java.util.*;
import java.io.*;

public class Code {
	
	static Scanner in;
	static int[][] connect4;
	static int winner;
	static String p1, p2;
	
	public static void main(String[] args) throws IOException, InterruptedException {
			in = new Scanner(System.in);
			
			connect4 = new int[10][10];
			winner = 0;
			
			connect4[0][0] = 8;
			for(int i = 1; i <= 9; i++) {
				connect4[0][i] = i;
				connect4[i][0] = i;
			}
			
			introduction();
			
	}
	
	public static void clearScreen() {
		for(int i = 0; i < 18; i++) System.out.println();
	}
	
	private static void print(String str) throws InterruptedException {
		for(int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
			Thread.sleep(60);
		}
		
	}
	
	private static void introduction() throws InterruptedException {
		for(int i = 0; i < 15; i++) System.out.println();
		//1.
		System.out.println(" ☻/"); System.out.println("/▌"); System.out.println("/" + '\\');
		print("hello there!");
		System.out.println();
		print("what is your name?");
		System.out.println();
		p1 = in.nextLine();
		print("and your friend's?");
		System.out.println();
		p2 = in.nextLine();
		clearScreen();
		
		//2.
		System.out.println(" ☻"); System.out.println("/▌\\"); System.out.println("/" + '\\');
		String temp = "hello" + " " + p1 + " and " + p2 + "! " + "My name is David and today you two will be going against each other on a connect-four game!";
		print(temp);
		System.out.println();
		print("Type 'start' when both of you are ready!");
		System.out.println();
		
		String t = in.nextLine();
		t = t.toLowerCase().trim();
		
		//3.
		while(!t.equals("start")) {
			clearScreen();
			print("Type 'start' when both of you are ready!");
			System.out.println();
			t = in.nextLine();
			t = t.toLowerCase().trim();
		}
		game();
	}
	
	private static void game() throws InterruptedException {

		clearScreen();
		System.out.println(" ☻"); System.out.println("/▌\\"); System.out.println("/" + '\\');
		print("Good luck! " + p1 + "'s marks will be 1s and " + p2 + "'s will be 2s. To mark, input the coordinates(x,y) one by one on the console. " + p1 + " goes first.");
		
		Thread.sleep(500);
		
		boolean five = false;
		while(five == false) {
			int count = 0;
			

			clearScreen();
			
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					if(connect4[i][j] == 0) {
						count++;
					}
					System.out.print(connect4[i][j] + " " );
				}
				System.out.println();
			}
			if(count == 0) {
				System.out.println("It's a draw!");
				break;
			}
			

			int x1 = in.nextInt();
			int y1 = in.nextInt();
			while(connect4[y1][x1] != 0) {
				clearScreen();
				print("Please input a coordinate that is empty");
				System.out.println();
				for(int i = 0; i < 10; i++) {
					for(int j = 0; j < 10; j++) {
						System.out.print(connect4[i][j] + " " );
					}
					System.out.println();
				}
				x1 = in.nextInt();
				y1 = in.nextInt();
			}
			connect4[y1][x1] = 1;
			
			if(checkFour() == true) {
				clearScreen();
				for(int i = 0; i < 10; i++) {
					for(int j = 0; j < 10; j++) {
						System.out.print(connect4[i][j] + " " );
					}
					System.out.println();
				}
				if(winner == 1) System.out.println(p1 + " wins the game! Congratulations " + p1 + "!");
				else if(winner == 2) System.out.println(p2 + " wins the game! Congratulations " + p2 + "!");
				break;
			}
			
			
			clearScreen();
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					if(connect4[i][j] == 0) {
						count++;
					}
					System.out.print(connect4[i][j] + " " );
				}
				System.out.println();
			}
			if(count == 0) {
				System.out.println("It's a draw!");
				break;
			}
			
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			while(connect4[y2][x2] != 0) {
				clearScreen();
				System.out.println("Please input a coordinate that is empty");
				System.out.println();
				for(int i = 0; i < 10; i++) {
					for(int j = 0; j < 10; j++) {
						System.out.print(connect4[i][j] + " " );
					}
					System.out.println();
				}
				x2 = in.nextInt();
				y2 = in.nextInt();
			}
			connect4[y2][x2] = 2;
			
			if(checkFour() == true) {
				five = true;
				
			}
		}
		clearScreen();
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(connect4[i][j] + " " );
			}
			System.out.println();
		}
		if(winner == 1) System.out.println(p1 + " wins the game! Congratulations " + p1 + "!");
		else if(winner == 2) System.out.println(p2 + " wins the game! Congratulations " + p2 + "!");
		
	}
	
	private static boolean checkFour() {
		for(int j = 1; j < 7; j++) {
			for(int i = 1; i < 10; i++) {
				if(connect4[i][j] == connect4[i][j+1] && connect4[i][j] == connect4[i][j+2] && connect4[i][j] == connect4[i][j+3] && connect4[i][j] != 0) {
					winner = connect4[i][j];
					return true;
				}
			}
		}
		for(int i = 1; i < 7; i++) {
			for(int j = 1; j < 10; j++) {
				if(connect4[i][j] == connect4[i+1][j] && connect4[i][j] == connect4[i+2][j] && connect4[i][j] == connect4[i+3][j] && connect4[i][j] != 0) {
					winner = connect4[i][j];
					return true;
				}
			}
		}
		
		for(int i = 4; i < 10; i++) {
			for(int j = 1; j < 7; j++) {
				if(connect4[i][j] == connect4[i-1][j+1] && connect4[i][j] == connect4[i-2][j+2] && connect4[i][j] == connect4[i-3][j+3] && connect4[i][j] != 0) {
					winner = connect4[i][j];
					return true;
				}
			}
		}
		
		for(int i = 4; i < 10; i++) {
			for(int j = 4; j < 10; j++) {
				if(connect4[i][j] == connect4[i-1][j-1] && connect4[i][j] == connect4[i-2][j-2] && connect4[i][j] == connect4[i-3][j-3] && connect4[i][j] != 0) {
					winner = connect4[i][j];
					return true;
				}
			}
		}
		return false;
	}
	
}




