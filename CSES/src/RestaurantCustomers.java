import java.io.*;
import java.util.*;

public class RestaurantCustomers {
	static class Customer {
		int time;
		int type;
	}

	static class CustomerComparator implements Comparator<Customer> {
		public int compare (Customer one, Customer two) {
			// use Integer.compare to avoid writing if statements
			return Integer.compare(one.time, two.time);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		Customer[] data = new Customer[2 * n];

		for (int x = 0; x < n; x++) {
			Customer c1 = new Customer();
			c1.time = Integer.parseInt(st.nextToken());
			c1.type = 1;

			Customer c2 = new Customer();
			c2.time = Integer.parseInt(st.nextToken());
			c2.type = -1;

			data[2 * x] = c1;
			data[2 * x + 1] = c2;
			
			if(x == n-1) continue;
			st = new StringTokenizer(in.readLine());
		}

		Arrays.sort(data, new CustomerComparator());

		int sum = 0;
		int answer = 0;
		for (Customer customer : data) {
			// if it is an arrival, add 1
			// if it is a departure, subtract 1
			sum += customer.type;
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
		in.close();
	}
}