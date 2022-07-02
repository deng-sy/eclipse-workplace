package Stack_Queue_Heap;
import java.util.*;
//ʵ��һ�������ļ�����������һ���򵥵ı��ʽ�ַ�����
//���ʽ�ַ���ֻ�����Ǹ�������+, -, *, /�������������� (�������� )�Ϳո�
public class Calculator3 {
    /**
     * @param s: the expression string
     * @return: the answer
     */
    public static int calculate(String s) {
        // Write your code here
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> nums = new Stack<>();   //����ջ
        Stack<Character> ops = new Stack<>();   //������ջ
        int num;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' '){
                continue;
            }
            if (Character.isDigit(c)) {			//�ַ���ת������
                num = c - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                nums.push(num);			//����ֱ�Ӵ���ջ��
            } else if (c == '(') {		//������ֱ�Ӵ���
                ops.push(c);
            } else if (c == ')') {		//����������
                while (ops.peek() != '('){		//��ջ�������ֽ�������
                    nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {   //����������
                while (!ops.isEmpty() && precedence(c, ops.peek())){		//��ջ�������ֽ�������
                    nums.push(operation(ops.pop(), nums.pop(),nums.pop()));
                }
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) {    //ȡ��ջ�������ֽ��в���
            nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }

    private static int operation(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;   //�ӷ�
            case '-': return a - b;	  //����
            case '*': return a * b;   //�˷�
            case '/': return a / b;   //����
        }
        return 0;
    }
    private static boolean precedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')'){
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(calculate(" 6-(4 / 2    )"));
    }
}
