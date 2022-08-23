package zhousai;

public class maximumSegmentSum {
    //    ²¢²é¼¯
    int[] f;

    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        long[] ans = new long[n];
        f = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            f[i] = i;
        }
        long[] sum = new long[n + 1];
        for (int i = n - 1; i > 0; i--) {
            int from = removeQueries[i];
            int to = find(from + 1);
            f[from] = to;
            sum[to] += sum[from] + nums[from];
            ans[i - 1] = Math.max(ans[i], sum[to]);
        }
        return ans;
    }

    private int find(int x) {
        return x == f[x] ? x : find(f[x]);
    }


}
