package bole;

//可删除一个元素的最大子数组和
public class maximumSum {
    public int maximumSum(int[] arr) {
        // write code here
        int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = arr[0];
        int ans = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(arr[i], dp[i - 1][0] + arr[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new maximumSum().maximumSum(new int[]{1, 2, 3, -4, 5}));
    }
}
