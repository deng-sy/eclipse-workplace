package Stack_Queue_Heap;
import java.util.*;
//实现一个基本的计算器来计算一个简单的表达式字符串。
//表达式字符串只包含非负整数、+, -, *, /操作符、左括号 (，右括号 )和空格。
public class Calculator3 {
    /**
     * @param s: the expression string
     * @return: the answer
     */
    public static int calculate(String s) {
        // Write your code here
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> nums = new Stack<>();   //数字栈
        Stack<Character> ops = new Stack<>();   //操作符栈
        int num;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' '){
                continue;
            }
            if (Character.isDigit(c)) {			//字符串转化数字
                num = c - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                nums.push(num);			//数字直接存入栈中
            } else if (c == '(') {		//左括号直接存入
                ops.push(c);
            } else if (c == ')') {		//遇到右括号
                while (ops.peek() != '('){		//对栈顶两数字进行运算
                    nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {   //遇到操作符
                while (!ops.isEmpty() && precedence(c, ops.peek())){		//对栈顶两数字进行运算
                    nums.push(operation(ops.pop(), nums.pop(),nums.pop()));
                }
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) {    //取出栈顶的数字进行操作
            nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }

    private static int operation(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;   //加法
            case '-': return a - b;	  //减法
            case '*': return a * b;   //乘法
            case '/': return a / b;   //除法
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
