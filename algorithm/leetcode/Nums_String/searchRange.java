package Nums_String;

//思路：找到第一个大于等于目标值和第一个大于目标值的位置
public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int left_idx = helper(nums, target, true);
        int right_idx = helper(nums, target, false) - 1;
        if (left_idx <= right_idx && right_idx < nums.length && nums[left_idx] == target && nums[right_idx] == target) {
            res[0] = left_idx;
            res[1] = right_idx;
        }
        return res;
    }

    private int helper(int[] array, int key, boolean isLower) {
        int left = 0, right = array.length - 1, res = array.length;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (array[mid] > key || (array[mid] >= key && isLower)) {
                right = mid - 1;
                res = mid;
            } else
                left = mid + 1;
        }
        return res;
    }
}
