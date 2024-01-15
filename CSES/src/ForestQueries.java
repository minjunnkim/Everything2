import java.io.*;
import java.util.*;

public class ForestQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        char[][] cc = new char[n][n];
        
        for (int i = 0; i < n; i++)
            br.readLine().getChars(0, n, cc[i], 0);
       
        System.out.println(Arrays.deepToString(cc));
        
        int[][] aa = new int[n + 1][n + 1];
       
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (cc[i][j] == '*')
                    aa[i + 1][j + 1]++;
        System.out.println(Arrays.deepToString(aa));
        
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                aa[i][j] += aa[i][j - 1];
        
        System.out.println(Arrays.deepToString(aa));
        
       
        for (int j = 1; j <= n; j++)
            for (int i = 1; i <= n; i++)
                aa[i][j] += aa[i - 1][j];
       
        System.out.println(Arrays.deepToString(aa));
        
        
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int il = Integer.parseInt(st.nextToken());
            int jl = Integer.parseInt(st.nextToken());
            int ir = Integer.parseInt(st.nextToken());
            int jr = Integer.parseInt(st.nextToken());
            sb.append(aa[ir][jr] - aa[il - 1][jr] - aa[ir][jl - 1] + aa[il - 1][jl - 1]).append("\n");
            
        }
        
        
        
        pw.println(sb.toString());
        
        
        pw.close();
        
    }
}


/*
4 3
.*..
*.**
**..
****
2 2 3 4
3 1 3 1
1 1 2 2
*/