import java.util.*;
import java.io.*;

public class mazetactoe {

	public static void main(String[] args) {
		System.out.println(sumSmallestInVisitedCells("4 5", "3 1 4 1 5 9 2 6 5 3 5 8 9 7 9 3 2 3 8 4", "6 2 6 4 3 3 8 3 2 7 7 2 3 8 3 3 4 6 2 6", "5 8 3 2 3 9 7 9 8 5 3 5 6 2 9 5 1 4 1 3"));

	}
	
	public static int sumSmallestInVisitedCells(String dim, String array1, String array2, String array3) {
        String[] dimensions = dim.split(" ");
        
        
        String[] temp1 = array1.split(" ");
        String[] temp2 = array2.split(" ");
        String[] temp3 = array3.split(" ");
        
        int[][] arr1 = new int[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];
        int[][] arr2 = new int[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];
        int[][] arr3 = new int[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];
        
        
        
        int n = 0;
        for(int i = 0 ; i < Integer.parseInt(dimensions[0]); i++) {
            for(int j = 0 ; j < Integer.parseInt(dimensions[1]); j++) {
                arr1[i][j] = Integer.parseInt(temp1[n]);
                arr2[i][j] = Integer.parseInt(temp2[n]);;
                arr3[i][j] = Integer.parseInt(temp3[n]);;
                n++;
            }
        }
        
        
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        boolean check = false;
        int x = 0;
        int y = 0;
        while(!check) {
            ans.add(Math.min(arr1[x][y], Math.min(arr2[x][y], arr3[x][y])));
            
            ArrayList<Integer> max = new ArrayList<Integer>();
            max.add(arr1[x][y+1]);
            max.add(arr2[x][y+1]);
            max.add(arr3[x][y+1]);
            max.add(arr1[x+1][y]);
            max.add(arr2[x+1][y]);
            max.add(arr3[x+1][y]);
            
            int m = Collections.max(max);
            int f = Collections.frequency(max, m);
            int ymax = Math.max(arr1[x][y+1], Math.max(arr2[x][y+1], arr3[x][y+1]));
            int xmax = Math.max(arr1[x+1][y], Math.max(arr2[x+1][y], arr3[x+1][y]));
            if(f > 1) {
            	x++;
            	y++;
            }
            else if(xmax > ymax) x++;
            else y++;
            
            if(x == (Integer.parseInt(dimensions[0])-1) || y == (Integer.parseInt(dimensions[1])-1)) {
            	
            	check = true;
            	ans.add(Math.min(arr1[x][y], Math.min(arr2[x][y], arr3[x][y])));
            }
        }
        
        
        int sum = 0;
        
        for(int i = 0; i < ans.size(); i++) {
            sum+=ans.get(i);
        }
        
        return sum;
    }

}
