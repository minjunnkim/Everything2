import java.util.*;
import java.io.*;
 
public class RestaurantCustomers2 {
 
    static BufferedReader in;
    static StringTokenizer st;
    static int n;
    static ArrayList<pair> a;
    
    public static void main(String[] args) throws IOException {
 
        in = new BufferedReader(new InputStreamReader(System.in));
        
        init();
        solve();
        
        in.close();
    }
    
    static void init() throws NumberFormatException, IOException {    
        n = Integer.parseInt(in.readLine());
        a = new ArrayList<pair>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(in.readLine());
            a.add(new pair(Integer.parseInt(st.nextToken()), 1));
            a.add(new pair(Integer.parseInt(st.nextToken()), -1));        
        }
        
        Collections.sort(a);
        //System.out.println(a);
    }
    
    static void solve() throws IOException {
        
        int cnt = 0;
        int max = 0;
        for(pair p:a) {
            cnt+=p.status;
            max = Math.max(cnt, max);
        }
        
        /*
         2,1
         3,1
         4,-1
         5,1
         8,-1
         9,-1
         */
        
        System.out.println(max);
    }
 
    static class pair implements Comparable<pair>{
 
        int time, status;
        pair(int s, int e){
            time = s;
            status = e;
        }
        @Override
        public int compareTo(pair that) {
            return this.time - that.time;
        }
        
        public String toString() {
            return time+" "+status;
        }
    }
}