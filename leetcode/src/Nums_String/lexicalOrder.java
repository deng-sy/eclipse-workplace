package Nums_String;

import java.util.*;

//给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
//
//你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
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

