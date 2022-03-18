package exercise_02;

import java.util.Scanner;

public class E2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=new int[20];
		int score=0;
		for(int i=0;i<20;i++) {
			a[i]=(int) (1+(Math.random()*100));
		}
		System.out.println("请输入答案，共10道题，每题10分");
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<10;i+=2) {
			System.out.println(a[i]+"+"+a[i+1]+"=?");
			int answer=sc.nextInt();
			if(a[i]+a[i+1]==answer) {
				score+=10;
				System.out.println("+10,当前得分："+score);
			}
			else {
				System.out.println("答错了，正确答案为："+(a[i]+a[i+1]));
			}
		}
		for(int i=10;i<20;i+=2) {
			if(a[i]<a[i+1]) {
				int tmp=a[i];
				a[i]=a[i+1];
				a[i+1]=tmp;
			}
			System.out.println(a[i]+"-"+a[i+1]+"=?");
			int answer=sc.nextInt();
			if(a[i]-a[i+1]==answer) {
				score+=10;
				System.out.println("+10,当前得分："+score);
			}
			else {
				System.out.println("答错了，正确答案为："+(a[i]-a[i+1]));
			}
		}
		switch(score) {
		case 100:System.out.println("酷毙了！");break;
		case 90:
		case 80:System.out.println("真棒！");break;
		case 70:
		case 60:System.out.println("不错！");break;
		default:System.out.println("再接再厉！");
		
		}

	}

}
