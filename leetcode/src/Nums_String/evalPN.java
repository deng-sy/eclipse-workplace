package Nums_String;

import java.util.Stack;

public class evalPN {
    public static int evalPN(String[]tokens){
        Stack<Integer>stack=new Stack<>();
        int n=tokens.length;
        for(int i=n-1;i>=0;i--){
            String token=tokens[i];
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
        String strs="* + 11 12 + 24 35";
        String[]tokens=strs.split(" ");
        System.out.println(evalPN(tokens));
    }
}
