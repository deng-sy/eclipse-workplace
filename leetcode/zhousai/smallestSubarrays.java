package zhousai;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

//6186. 按位或最大的最小子数组长度
public class smallestSubarrays {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] bit_idx = new int[32];
        Arrays.fill(bit_idx, n);
        for (int i = n - 1; i >= 0; i--) {
            int end = i;
            for (int j = 0; j < 32; j++) {
                if ((nums[i] >> j & 1) == 1)
                    bit_idx[j] = i;
                else if (bit_idx[j] != n)
                    end = Math.max(end, bit_idx[j]);
            }
            ans[i] = end - i + 1;
        }

        return ans;
    }
}
