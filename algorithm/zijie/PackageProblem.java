package zijie;

import java.util.Arrays;
//和为k的方案数
public class PackageProblem {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 0, 2, 0};
        int max = Arrays.stream(nums).sum();
        int[] dp = new int[max + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = max; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        System.out.println(Arrays.toString(dp));

    }
}
