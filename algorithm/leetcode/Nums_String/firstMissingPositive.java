package Nums_String;
//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
public class firstMissingPositive {

    //    方法一：哈希表
    public static int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0)
                nums[i] = n + 1;
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n)
                nums[num - 1] = -Math.abs(nums[num - 1]);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        return n + 1;
    }

    //    方法二：置换
    public static int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i])
                swap(nums, nums[i] - 1, i);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return n + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
}
