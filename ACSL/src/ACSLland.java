import java.io.*;
import java.util.*;



public class ACSLland{

    static class Result {
        public static String method1(String line) {   
            String ans = "";
            // Write your code here
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