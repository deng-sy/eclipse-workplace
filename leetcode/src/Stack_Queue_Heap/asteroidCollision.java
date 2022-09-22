package Stack_Queue_Heap;

import java.util.*;

//����һ���������� asteroids����ʾ��ͬһ�е����ǡ�
//���������е�ÿһ��Ԫ�أ������ֵ��ʾ���ǵĴ�С��������ʾ���ǵ��ƶ���������ʾ�����ƶ�������ʾ�����ƶ�����ÿһ����������ͬ���ٶ��ƶ���
//�ҳ���ײ��ʣ�µ��������ǡ���ײ�������������໥��ײ����С�����ǻᱬը������������Ǵ�С��ͬ�����������Ƕ��ᱬը�������ƶ�������ͬ�����ǣ���Զ���ᷢ����ײ��

public class asteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int ast : asteroids) {
            collision:
            {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }
}
