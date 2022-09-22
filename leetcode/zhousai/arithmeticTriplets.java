package zhousai;
//2367. 算术三元组的数目
//给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。如果满足下述全部条件，则三元组 (i, j, k) 就是一个 算术三元组 ：
//
//i < j < k ，
//nums[j] - nums[i] == diff 且
//nums[k] - nums[j] == diff
//返回不同 算术三元组 的数目。
import java.util.*;

public class arithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for (int num : nums) {
            set.add(num);
            if (set.contains(num - diff) && set.contains(num - diff * 2))
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 4, 6, 7, 10};
        int diff = 3;
        long time=System.currentTimeMillis();
        System.out.println(new arithmeticTriplets().arithmeticTriplets(nums, diff));
        System.out.println(System.currentTimeMillis()-time);
    }
}
