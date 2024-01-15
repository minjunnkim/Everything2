public class Eratosthenes {

    public static void main(String[] args) {
        
        int n = 100000;
        
        boolean isPrime[] = new boolean[101];
        isPrime[0] = isPrime[1] = false; 
         
        for (int i = 2; i <= n; i++) 
            isPrime[i] = true; 
         
        for (int p = 2; p * p <= n; p++){ 
         // If isPrime[p] is not changed, 
         // then it is a prime 
         if (isPrime[p] == true)  { 
             // Update all multiples of p 
             for (int i = p * p; i <= n; i += p) 
                 isPrime[i] = false; 
             } 
         } 
    }
}