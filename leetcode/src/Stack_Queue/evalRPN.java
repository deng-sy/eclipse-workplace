package Stack_Queue;

import java.util.Stack;

//根据逆波兰表示法，求表达式的值。有效的算符包括 +、-、*、/ 。每个运算对象可以
//是整数，也可以是另一个逆波兰表达式。
public class evalRPN {
    public static int evalRPN(String[]tokens){
        Stack<Integer>stack=new Stack<>();

        for(String token:tokens){
            if(token.equals("+")){
                int num1=stack.pop();
                int num2=stack.pop();
                stack.push(num2+num1);
            }else if(token.equals("-")){
                int num1=stack.pop();
                int num2=stack.pop();
                stack.push(num2-num1);
            }else if(token.equals("*")){
                int num1=stack.pop();
                int num2=stack.pop();
                stack.push(num2*num1);
            }else if(token.equals("/")){
                int num1=stack.pop();
                int num2=stack.pop();
                stack.push(num2/num1);
            }else
                stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String[]tokens={"2","1","3","+","*"};
        System.out.println(evalRPN(tokens));
    }
}
