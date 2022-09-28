package dyn_pro;

import java.util.*;

//��������
//��N����Ʒ��һ������ΪV�İ�����i����Ʒ��������w[i]����ֵ��v[i]������Щ��Ʒװ�뱳����ʹ
//��Щ��Ʒ�������ܺͲ��ܳ��������������Ҽ�ֵ�ܺ����
public class packageProblem {
    public static int packageProblem1(int maxWeight, int[] weights, int[] values) {
        int[] dp = new int[maxWeight + 1];//dp[i]��ʾװ���������Ϊi�ܻ�õ�����ֵ
        for (int i = 1; i <= values.length; i++) {
            for (int j = maxWeight; j >= 1; j--) {
                if (j >= weights[i - 1])
                    dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
            }
        }
        return dp[maxWeight];
    }

    public static int packageProblem2(int[] weights, int[] values, int i, int j) {
        if (i == -1)
            return 0;
        int v1 = 0;
        if (j >= weights[i])
            v1 = packageProblem2(weights, values, i - 1, j - weights[i]) + values[i];
        int v2 = packageProblem2(weights, values, i - 1, j);
        return Math.max(v1, v2);
    }


    public static void main(String[] args) {
        int maxWeight = 4;
        int[] weights = {1, 4, 3};
        int[] values = {150, 300, 200};
        long starTime1 = System.currentTimeMillis();
        System.out.println(packageProblem1(maxWeight, weights, values));
        long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1 - starTime1);

        long starTime2 = System.currentTimeMillis();
        System.out.println(packageProblem2(weights, values, weights.length - 1, maxWeight));
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime2 - starTime2);
    }
}
