package exercise_08;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) throws IllegalTriangleException  {
		System.out.println("输入三角形三条边：");
		Scanner sc=new Scanner(System.in);
		Triangle tri=new Triangle(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
		System.out.println("输入颜色：");
		tri.setColor(sc.next());
		System.out.println("是否填充：");
		tri.setFilled(sc.nextBoolean());
		
		System.out.println("三角形属性：");
		System.out.println("面积："+tri.getArea());
		System.out.println(tri.toString());
		System.out.println("颜色："+tri.getColor());
		System.out.println("是否填充："+tri.isFilled());
	}
}
