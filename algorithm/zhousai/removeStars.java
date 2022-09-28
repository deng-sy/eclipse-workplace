package zhousai;

import java.util.Stack;

//����һ�����������Ǻ� * ���ַ��� s ��
//
//��һ�������У�����ԣ�
//
//ѡ�� s �е�һ���Ǻš�
//�Ƴ��Ǻ� ��� ������Ǹ� ���Ǻ� �ַ������Ƴ����Ǻ�����
//�����Ƴ� ���� �Ǻ�֮����ַ�����
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
