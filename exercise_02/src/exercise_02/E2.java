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
		System.out.println("������𰸣���10���⣬ÿ��10��");
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<10;i+=2) {
			System.out.println(a[i]+"+"+a[i+1]+"=?");
			int answer=sc.nextInt();
			if(a[i]+a[i+1]==answer) {
				score+=10;
				System.out.println("+10,��ǰ�÷֣�"+score);
			}
			else {
				System.out.println("����ˣ���ȷ��Ϊ��"+(a[i]+a[i+1]));
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
				System.out.println("+10,��ǰ�÷֣�"+score);
			}
			else {
				System.out.println("����ˣ���ȷ��Ϊ��"+(a[i]-a[i+1]));
			}
		}
		switch(score) {
		case 100:System.out.println("����ˣ�");break;
		case 90:
		case 80:System.out.println("�����");break;
		case 70:
		case 60:System.out.println("����");break;
		default:System.out.println("�ٽ�������");
		
		}

	}

}
