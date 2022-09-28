package dyn_pro;

//求解目标和

//思路：转变为筛选元素使得和为（sum-target）/2
public class findTargetSumWays {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum < target) || ((sum - target) & 1) != 0)
            return 0;
        int cap = (sum - target) >> 1;
        int[] dp = new int[cap + 1];
        dp[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = cap; j >= 0; j--) {
                if (j >= nums[i - 1])
                    dp[j] += dp[j - nums[i - 1]];
            }
        }
        return dp[cap];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 6};
        int target = 12;
        System.out.println(findTargetSumWays(nums, target));
//        System.out.println(canPartition2(nums));
    }
}
