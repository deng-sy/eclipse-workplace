package Nums_String;

import java.util.*;

class reverseWords {
    public static String reverseWords(String s) {
        Stack<String> stack = new Stack();
        int idx = 0;
        while (idx < s.length()) {
            while (idx < s.length() && s.charAt(idx) == ' ') {
                idx++;
            }
            if (idx == s.length())
                break;
            StringBuilder sb = new StringBuilder();
            while (idx < s.length() && s.charAt(idx) != ' ') {
                sb.append(s.charAt(idx));
                idx++;
            }
            stack.push(sb.toString());
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (!stack.isEmpty()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
}
