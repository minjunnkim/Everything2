import java.util.*;
import java.io.*;

public class prob05 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        if(n == 1) System.out.println(n + " is NOT Prime");
        else if(n <= 3) System.out.println(n + " is PRIME");
        else if(n%2==0 || n%3 == 0) System.out.println(n + " is NOT Prime");
        else {
            boolean c = true;
            int count = 5;
            while(Math.pow(count,2) <= n) {
                if(n%count == 0 || n%(count+2)==0) {
                    System.out.println(n + " is NOT Prime");
                    c = false;
                }
                count += 6;
            }
            if(c == true) System.out.println(n + " is PRIME");
        }
    }

}