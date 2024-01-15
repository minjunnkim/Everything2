import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;
 
class probA {
    // Utility method to find the divisors of
    // n and store in vector v[]
    static Vector<Integer> findDivisors(int n)
    {
        Vector<Integer> v = new Vector<>();
 
        // Vector is used to store  the divisors
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                // If n is a square number, push
                // only one occurrence
                if (n / i == i)
                    v.add(i);
                else {
                    v.add(i);
                    v.add(n / i);
                }
            }
        }
        return v;
    }
 
    // method to find pairs such that (a%b = k)
    static boolean printPairs(int arr[], int n, int k)
    {
        // Store all the elements in the map
        // to use map as hash for finding elements
        // in O(1) time.
        HashMap<Integer, Boolean> occ = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++)
            occ.put(arr[i], true);
        //System.out.println(occ);
        boolean isPairFound = false;
        for (int i = 0; i < n; i++) {
            // Print all the pairs with (a, b) as
            // (k, numbers greater than k) as
            // k % (num (> k)) = k i.e. 2%4 = 2
        	//System.out.println(occ.get(k) + " " + k + " " + arr[i]);
            if (occ.get(k) != null && k < arr[i]) {
                //System.out.print("(" + k + ", " + arr[i] + ") ");
                count++;
                isPairFound = true;
            }
            // Now check for the current element as 'a'
            // how many b exists such that a%b = k
            if (arr[i] >= k) {
                // find all the divisors of (arr[i]-k)
                Vector<Integer> v = findDivisors(arr[i] - k);
 
                // Check for each divisor i.e. arr[i] % b = k
                // or not, if yes then print that pair.
                for (int j = 0; j < v.size(); j++) {
                    if (arr[i] % v.get(j) == k && arr[i] != v.get(j) && occ.get(v.get(j)) != null) {
                        //System.out.print("(" + arr[i] + ", "
                                        // + v.get(j) + ") ");
                        count++;
                        isPairFound = true;
                    }
                }
 
                // Clear vector
                v.clear();
            }
            
        }
        System.out.println(count);
        return isPairFound;
    }
 
    // Driver method
    public static void main(String args[])
    {	
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt(); in.nextLine();
        int arr[] = new int[n];
        
        for(int i = 0; i < n; i++) {
        	arr[i] = in.nextInt();
        }
        int k = 0;
 
        if (printPairs(arr, n, k) == false);
            //System.out.println("No such pair exists");
    }
}