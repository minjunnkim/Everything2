import java.io.*;
import java.util.*;



public class Sushi{
	
	
    static class Result {
        public static String method1(String line) {  
        	line = line.replaceAll(" ", "");
        	String ans = "";
            char[] arr = line.toCharArray();

            int total = 0;
            for(int i = 0; i < 5; i++) {
	            if(arr[i] == 'R') total+=1;
	            if(arr[i] == 'O') total+=2;
	            if(arr[i] == 'B') total+=3;
	            if(arr[i] == 'Y') total+=4;
	            if(arr[i] == 'W') total+=5;
            }           
            
            String ten = "0";
            String five = "0";
            String one = "0";
            if(total % 10 >= 0 && total != total%10) {
            	ten = Integer.toString(total/10);
            	total -= Integer.parseInt(ten)*10;
            }
            if(total % 5 >= 0 && total != total%5) {
            	five = Integer.toString(total/5);
            	total -= Integer.parseInt(five)*5;
            }
            one = Integer.toString(total);
            
            ans = ten+five+one;
            
            return ans;
        }
    }


    // TEST FILE NAME: input.txt
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new FileReader("input.txt"));    // TEST FILE NAME: input.txt


        for (int i = 0; i < 5; i++) {
            String result = Result.method1(in.nextLine().trim());    //result's data type may be changed.

            System.out.println(result);
        }

        in.close();
    }
}