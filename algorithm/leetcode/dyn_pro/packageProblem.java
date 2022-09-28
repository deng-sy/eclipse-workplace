package dyn_pro;

import java.util.*;

//背包问题
//有N件物品和一个容量为V的包，第i件物品的重量是w[i]，价值是v[i]，求将哪些物品装入背包可使
//这些物品的重量总和不能超过背包容量，且价值总和最大。
public class packageProblem {
    public static int packageProblem1(int maxWeight, int[] weights, int[] values) {
        int[] dp = new int[maxWeight + 1];//dp[i]表示装入最大重量为i能获得的最大价值
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
