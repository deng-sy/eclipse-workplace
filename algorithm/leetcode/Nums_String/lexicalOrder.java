package Nums_String;

import java.util.*;

//����һ������ n �����ֵ��򷵻ط�Χ [1, n] ������������
//
//��������һ��ʱ�临�Ӷ�Ϊ O(n) ��ʹ�� O(1) ����ռ���㷨��
public class lexicalOrder {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList();
        int num = 1;
        for (int i = 1; i <= n; i++) {
            ret.add(num);
            if (num * 10 <= n)
                num *= 10;
            else {
                while (num % 10 == 9 || num + 1 > n)
                    num /= 10;
                num++;
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.print(lexicalOrder(16));
    }
}

