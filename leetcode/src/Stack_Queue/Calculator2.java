package Stack_Queue;
import java.util.*;
//s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
public class Calculator2 {
//    法一：不用栈
    public int calculate1(String s) {
        int res=0,mul=0;
        char lastOperator='#';
        int n=s.length();
        for(int i=0;i<n;i++){
            while(i<n&&s.charAt(i)==' '){
                i++;
            }
            if(i==n)
                break;
            int val=0;
            while(i<s.length()&&Character.isDigit(s.charAt(i))){
                val=val*10+s.charAt(i)-'0';
                i++;
            }

            if(lastOperator=='#'){
                res=val;
                mul=val;
            }
            else{
                switch(lastOperator){
                    case '+':
                        res=res+val;
                        mul=val;
                        break;
                    case '-':
                        res=res-val;
                        mul=-val;
                        break;
                    case '*':
                        res=res-mul+mul*val;
                        mul=mul*val;
                        break;
                    case '/':
                        res=res-mul+mul/val;
                        mul=mul/val;
                        break;
                    default:
                        break;
                }
            }

            while(i<n&&s.charAt(i)==' '){
                i++;
            }
            if(i==n)
                break;
            lastOperator=s.charAt(i);
        }
        return res;
    }
//    法二：栈
public int calculate2(String s) {
    Deque<Integer> stack = new LinkedList<>();
    char preSign = '+';
    int num = 0;
    int n = s.length();
    for (int i = 0; i < n; ++i) {
        if (Character.isDigit(s.charAt(i))) {
            num = num * 10 + s.charAt(i) - '0';
        }
        if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
            switch (preSign) {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '*':
                    stack.push(stack.pop() * num);
                    break;
                default:
                    stack.push(stack.pop() / num);
            }
            preSign = s.charAt(i);
            num = 0;
        }
    }
    int ans = 0;
    while (!stack.isEmpty()) {
        ans += stack.pop();
    }
    return ans;
}


}
