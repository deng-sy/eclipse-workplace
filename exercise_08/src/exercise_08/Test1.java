package exercise_08;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) throws IllegalTriangleException  {
		System.out.println("���������������ߣ�");
		Scanner sc=new Scanner(System.in);
		Triangle tri=new Triangle(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
		System.out.println("������ɫ��");
		tri.setColor(sc.next());
		System.out.println("�Ƿ���䣺");
		tri.setFilled(sc.nextBoolean());
		
		System.out.println("���������ԣ�");
		System.out.println("�����"+tri.getArea());
		System.out.println(tri.toString());
		System.out.println("��ɫ��"+tri.getColor());
		System.out.println("�Ƿ���䣺"+tri.isFilled());
	}
}
