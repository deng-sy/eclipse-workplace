package zhousai;

import java.util.Stack;

//给你一个包含若干星号 * 的字符串 s 。
//
//在一步操作中，你可以：
//
//选中 s 中的一个星号。
//移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
//返回移除 所有 星号之后的字符串。
public class removeStars {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '*')
                stack.pop();
            else
                stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
