package exercise_02;

import java.util.Scanner;

public class E1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double rate,amount;
		int index;
		System.out.println("Enter the exchange rate from dollars to RMB:");
		rate=sc.nextDouble();
		System.out.println("Enter 0 to convert dollars to RMB and 1 vice versa:");
		index=sc.nextInt();
		switch (index) {
		case 0:
			System.out.println("Enter the dollar amount:");
			amount=sc.nextDouble();
			System.out.println("$"+amount+" is "+amount*rate+" yuan");
			break;
		case 1:
			System.out.println("Enter the RMB amount:");
			amount=sc.nextDouble();
			System.out.println(amount+" yuan is "+"$"+amount/rate);
			break;
		default:
			break;
		}
		
	}

}
