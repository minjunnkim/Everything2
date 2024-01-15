import java.io.*;
import java.text.*;
import java.time.*;
import java.util.*;

public class Prob24 {
	
	static Calendar startPeriod, endPeriod;
	public static void main(String[] args) throws IOException, ParseException{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); 
		in.nextLine();
		
		for(int i = 0; i < n; i++) {
			String input = in.nextLine();
			String pattern = "dd/MM/yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			Date date = simpleDateFormat.parse(input);
			
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			
			if(cal.get(Calendar.DAY_OF_WEEK) == 1) cal.add(Calendar.DATE, -2);
			if(cal.get(Calendar.DAY_OF_WEEK) == 7) cal.add(Calendar.DATE, -1);
			
			
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);
			
			endPeriod = getLastFriday(month, year);
			startPeriod = getLastFriday(month-1, year);
			
			//System.out.println(Integer.parseInt(endPeriod.getTime().toString().substring(8,10)) + " " + Integer.parseInt(cal.getTime().toString().substring(8,10)));
		
			if(endPeriod.get(Calendar.DAY_OF_MONTH) < cal.get(Calendar.DAY_OF_MONTH)) {
				if(month == 12) {
					month = 1;
					year++;
					endPeriod = getLastFriday(month, year);
					
				}
				else {
					month++;
					endPeriod = getLastFriday(month, year);
				}
			}
			
			if(month == 1) {
				startPeriod = getLastFriday(12, year-1);
			}
			else {
				startPeriod = getLastFriday(month-1, year);
			}
			
			startPeriod.add(Calendar.DAY_OF_YEAR, 3);
			
			System.out.println(startPeriod.getTime() + " " + endPeriod.getTime());
			
			int startMonth = startPeriod.get(Calendar.MONTH);
			int startDay = startPeriod.get(Calendar.DATE);
			int endMonth = endPeriod.get(Calendar.MONTH);
			int endDay = endPeriod.get(Calendar.DATE);
			
			System.out.println(fortyHourCount() + " " + fourTenCount() + " " + nineEightyACount() + " " + nineEightyBCount());
			
			
			
		}
	}
	
	static Calendar getLastFriday( int month, int year ) {
		   Calendar cal = Calendar.getInstance();
		   cal.set( year, month + 1, 1 );
		   cal.add( Calendar.DAY_OF_MONTH, -( cal.get( Calendar.DAY_OF_WEEK ) % 7 + 1 ) );
		   return cal;
	}
	
	static int fortyHourCount() {
		int count = 0;
		Calendar temp = (Calendar) startPeriod.clone();
		boolean check = true;
		while(check) {
			if(temp.get(Calendar.DAY_OF_WEEK) >= 2 && temp.get(Calendar.DAY_OF_WEEK) <= 6) count++;
			temp.add(Calendar.DATE, 1);
			if(temp.get(Calendar.DATE) == endPeriod.get(Calendar.DATE) && temp.get(Calendar.MONTH) == endPeriod.get(Calendar.MONTH)) {
				count++;
				check = false;
			}
		}
		return count;
	}
	
	static int fourTenCount() {
		int count = 0;
		Calendar temp = (Calendar) startPeriod.clone();
		boolean check = true;
		while(check) {
			if(temp.get(Calendar.DAY_OF_WEEK) >= 2 && temp.get(Calendar.DAY_OF_WEEK) <= 5) count++;
			temp.add(Calendar.DATE, 1);
			if(temp.get(Calendar.DATE) == endPeriod.get(Calendar.DATE) && temp.get(Calendar.MONTH) == endPeriod.get(Calendar.MONTH)) {
				check = false;
			}
		}
		return count;
	}

	static int nineEightyACount() {
		int count = 0;
		Calendar temp = (Calendar) startPeriod.clone();
		boolean check = true;
		boolean fri = workNoWork(temp.get(Calendar.DATE), temp.get(Calendar.MONTH), temp.get(Calendar.YEAR));
		while(check) {
			if(temp.get(Calendar.DAY_OF_WEEK) >= 2 && temp.get(Calendar.DAY_OF_WEEK) <= 5) count++;
			if(temp.get(Calendar.DAY_OF_WEEK) == 6 && fri) {
				count++;
				if(temp.get(Calendar.YEAR) != startPeriod.get(Calendar.YEAR)) fri = true;
				else fri = false;
			}
			if(temp.get(Calendar.DAY_OF_WEEK) == 6 && !fri) fri = true;
			temp.add(Calendar.DATE, 1);
			if(temp.get(Calendar.DATE) == endPeriod.get(Calendar.DATE) && temp.get(Calendar.MONTH) == endPeriod.get(Calendar.MONTH)) {
				check = false;
			}
		}
		return count;
	}
	
	static int nineEightyBCount() {
		int count = 0;
		Calendar temp = (Calendar) startPeriod.clone();
		boolean check = true;
		boolean fri = workNoWork(temp.get(Calendar.DATE), temp.get(Calendar.MONTH), temp.get(Calendar.YEAR));
		while(check) {
			if(temp.get(Calendar.DAY_OF_WEEK) >= 2 && temp.get(Calendar.DAY_OF_WEEK) <= 5) count++;
			if(temp.get(Calendar.DAY_OF_WEEK) == 6 && fri) {
				count++;
				fri = false;
			}
			if(temp.get(Calendar.DAY_OF_WEEK) == 6 && !fri) {
				if(temp.get(Calendar.YEAR) != startPeriod.get(Calendar.YEAR)) fri = false;
				else fri = true;
			}
			temp.add(Calendar.DATE, 1);
			if(temp.get(Calendar.DATE) == endPeriod.get(Calendar.DATE) && temp.get(Calendar.MONTH) == endPeriod.get(Calendar.MONTH)) {
				check = false;
			}
		}
		return count;
	}
	
	static boolean workNoWork(int date, int month, int year) {
		
	}
}
