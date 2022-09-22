package Nums_String;

import java.util.*;

public class findPairs {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1, right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] - nums[i] == k) {
                    ans++;
                    break;
                } else if (nums[mid] - nums[i] > k) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return ans;
    }
}
