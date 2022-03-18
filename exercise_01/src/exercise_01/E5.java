package exercise_01;




public class E5 {
	private static int result; // 静态变量，用于存储运行结果
	public class Calculator{

   

    public void add(int n) {

        result = result + n;

    }

    public void substract(int n) {

        result = result - n;  

    }

    public void multiply(int n) {
    	result=result*n;

    }         // 此方法尚未写好，请补充

    public void divide(int n) {
    	result=result/n;

    	         // 此方法尚未写好，请补充

    }

    public void square() {
    	result=(int) Math.sqrt(result);

    	         // 此方法尚未写好，请补充

    }

    public void power(int n) {
    	result=(int) Math.pow(result, n);

             // 此方法尚未写好，请补充

    }

    public void clear() {     // 将结果清零

        result = 0;

    }

    public int getResult() {

        return result;

    }

}

public class TestCalculator{
	
}
}