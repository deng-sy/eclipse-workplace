package exercise_02;

import java.util.Scanner;

public class E3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		double salary,s,tax;
		salary=sc.nextInt();
		if (salary>5000) {
			s=salary-5000;
			if(s<3000) {
				tax=s*0.03;
			}
			else if(s>=3000&&s<12000) {
				tax=s*0.1;
			}
			else if(s>=12000&&s<25000) {
				tax=s*0.2;
			}
			else if(s>=12000&&s<35000) {
				tax=s*0.25;
			}
			else if(s>=35000&&s<55000) {
				tax=s*0.3;
			}
			else if(s>=55000&&s<80000) {
				tax=s*0.35;
			}
			else {
				tax=s*0.45;
			}
			System.out.println("应缴税："+tax+" 元");
			
		}
		else {
			System.out.println("不需要缴税");
		}

	}

}
