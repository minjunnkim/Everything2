package _19_December;

import java.util.*;
import java.io.*;

public class lineup {

	static Scanner in;
	static PrintWriter out;
	static int n;
	static String[] condi;
	static String[] arr = {"Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue"};
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("lineup.in"));
			out = new PrintWriter(new File("lineup.out"));
			
			init();
			solve();
			
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		n = in.nextInt();
		in.nextLine();
		condi = new String[n*2];
		
		for(int i = 0; i < n*2; i+=2) {
			String[] temp = in.nextLine().replace("must be milked beside ", "").split(" ");
			
			condi[i] = temp[0];
			condi[i+1] = temp[1];
		}
		
		Arrays.sort(arr);
		
	}
	
	private static void solve() {
		lineup pa=new lineup();
		
		
		List<List<String>> permute = pa.permute(arr);
		
		List<String> ans = new ArrayList<String>();
		
		for(List<String> perm:permute) {
			int check = 0;
			for(int i = 0; i < n*2; i+=2) {
				if(Math.abs(perm.indexOf(condi[i]) - perm.indexOf(condi[i+1])) == 1) {
					check++;
				}
			}
			if(check == n) {
				ans = perm;
				break;
			}
		}
		
		for(int i = 0; i < ans.size(); i++) {
			out.println(ans.get(i));
		}
		
	}
	
	public List<List<String>> permute(String[] arr) {
		List<List<String>> list = new ArrayList<>();
		permuteHelper(list, new ArrayList<>(), arr);
		return list;
	}

	private void permuteHelper(List<List<String>> list, List<String> resultList, String[] arr){
 
		if(resultList.size() == arr.length){
			list.add(new ArrayList<>(resultList));
		} 
		else{
			for(int i = 0; i < arr.length; i++){ 
 
				if(resultList.contains(arr[i])) 
				{
					continue; 
				}
				resultList.add(arr[i]);
				permuteHelper(list, resultList, arr);
				resultList.remove(resultList.size() - 1);
			}
		}
	} 
}
	
