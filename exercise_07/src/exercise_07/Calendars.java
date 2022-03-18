package exercise_07;

import java.text.*;
import java.util.*;

public class Calendars {

	public static void main(String[] args) throws ParseException {
		Calendar c=new GregorianCalendar();
		System.out.println("输入年份和月：");
		Scanner sc=new Scanner(System.in);
		int year=sc.nextInt();
		int month=sc.nextInt()-1;
		c.set(Calendar.YEAR,year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DATE, 1);
		
		DateFormat df=new SimpleDateFormat("MM");
		Date date=df.parse(String.valueOf(month+1));
		df=new SimpleDateFormat("MMMMM",Locale.US);
		
		System.out.println("                   "+df.format(date)+" , "+year);
		System.out.println("----------------------------------------------------");
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		
		for(int i=0;i<c.get(Calendar.DAY_OF_WEEK)-1;i++) {
			System.out.print("\t");
		}
		int days=c.getActualMaximum(Calendar.DATE);
		for(int i=1;i<=days;i++) {
			System.out.print(c.get((Calendar.DAY_OF_MONTH))+"\t");
			if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)
				System.out.println();
			c.add(Calendar.DAY_OF_MONTH, 1);

		}

	}

}
