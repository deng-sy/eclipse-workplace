package Stack_Queue;

import java.util.Stack;

//�����沨����ʾ��������ʽ��ֵ����Ч��������� +��-��*��/ ��ÿ������������
//��������Ҳ��������һ���沨�����ʽ��
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
