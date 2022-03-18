package exercise_01;


public class Test{
	public int add(int a,int b) {
		try {
			System.out.println("try");
			return a+b;
		}catch(Exception e){
			System.out.println("catch");
		}finally {
			System.out.println("finally");
		}
		return 0;
		
	}
	
	public static void main(String[] args) {
		Test test=new Test();
		System.out.println("∫Õ «£∫"+test.add(9,34));
	}
}