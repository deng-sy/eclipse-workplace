package dyn_pro;
//给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
public class maxSumDivThree {
    public static int maxSumDivThree(int[] nums) {
        int n=nums.length;
        int[][]dp=new int[n+1][3];//dp[i][j]表示前i个元素中被3除余j的最大元素和
        for(int i=0;i<=n;i++){
            for(int j=0;j<3;j++){
                dp[i][j]=Integer.MIN_VALUE;
            }
        }
        dp[0][0]=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                dp[i+1][j]=Math.max(dp[i+1][j],dp[i][j]);
                dp[i+1][j]=Math.max(dp[i+1][j],dp[i][((j-nums[i])%3+3)%3]+nums[i]);

            }
        }
        return dp[n][0];

    }

    public static void main(String[] args) {
        int[]nums=new int[]{3,6,5,1,8};
        System.out.println(maxSumDivThree(nums));

    }

}
