package Stack_Queue_Heap;

import java.util.*;
//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
//s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
//s 表示一个有效的表达式
//'+' 不能用作一元运算(例如， "+1"?和 "+(2 + 3)"?无效)
//'-' 可以用作一元运算(即 "-1"?和 "-(2 + 3)"?是有效的)

public class Calculator1 {
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;
        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
}
