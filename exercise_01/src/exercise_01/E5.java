package exercise_01;




public class E5 {
	private static int result; // ��̬���������ڴ洢���н��
	public class Calculator{

   

    public void add(int n) {

        result = result + n;

    }

    public void substract(int n) {

        result = result - n;  

    }

    public void multiply(int n) {
    	result=result*n;

    }         // �˷�����δд�ã��벹��

    public void divide(int n) {
    	result=result/n;

    	         // �˷�����δд�ã��벹��

    }

    public void square() {
    	result=(int) Math.sqrt(result);

    	         // �˷�����δд�ã��벹��

    }

    public void power(int n) {
    	result=(int) Math.pow(result, n);

             // �˷�����δд�ã��벹��

    }

    public void clear() {     // ���������

        result = 0;

    }

    public int getResult() {

        return result;

    }

}

public class TestCalculator{
	
}
}