package exercise_08;
import java.io.IOException;
import java.util.*;
public class Test {
	static int i=47;
	public void call() {
		System.out.println("����call����");
		for(int i=0;i<3;i++) {
			System.out.print(i+" ");
			if(i==2) {
				System.out.println("\n");
			}
		}
	}
	public Test() {}
	public static void main(String[] args) {
		Test t1=new Test();
		Test t2=new Test();
		t2.i=60;
		System.out.println("��һ���� "+t1.i++);
		t1.call();
		System.out.println("�ڶ����� "+t2.i);
		t2.call();
	}
}
