package zhousai;

import java.util.Arrays;

public class minimumReplacement {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        int next = nums[n - 1];
        long ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= next) {
                next = nums[i];
                continue;
            }
            int k = nums[i] / next;
            if (nums[i] % next == 0) {
                ans += k - 1;
            } else {
                ans += k;
                next = nums[i] / (k + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {12, 9, 7, 6, 17, 19, 21};
        System.out.println(new minimumReplacement().minimumReplacement(nums));
    }
}
