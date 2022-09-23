package zhousai;

public class zeroFilledSubarray {
    public static long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        int l = -1;
        long ans = 0;
        for (int r = 0; r < n; r++) {
            int num = nums[r];
            if (num != 0) {
                l = r;
                continue;
            }
            ans += r - l;

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 2, 0, 0};
        System.out.println(zeroFilledSubarray(nums));
    }
}
