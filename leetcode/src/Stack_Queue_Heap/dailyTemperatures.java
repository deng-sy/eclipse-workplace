package Stack_Queue_Heap;

import java.util.*;
//����һ����������?temperatures?����ʾÿ����¶ȣ�����һ������?answer?������?answer[i]?��ָ�ڵ� i ��֮�󣬲Ż��и��ߵ��¶ȡ������������֮�󶼲������ߣ����ڸ�λ����?0 �����档

public class dailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < len; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int pre = stack.pop();
                res[pre] = i - pre;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
