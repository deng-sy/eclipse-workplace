package exercise_01;

import java.util.Scanner;

public class E4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		double m,d,y;
		m=sc.nextDouble();
		d=m/24/60;
		y=d/365;
		System.out.println("包含天数："+d);
		System.out.println("包含年数："+y);

	}

}
