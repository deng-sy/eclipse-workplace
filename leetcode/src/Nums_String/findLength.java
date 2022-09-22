package Nums_String;

import java.util.Map;

//两个数组的公共长度
public class findLength {
    public static int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int res = 0;
        for (int i = 0; i < len1; i++) {
            int len = Math.min(len1 - i, len2);
            int max = maxLength(nums1, nums2, i, 0, len);
            res = Math.max(res, max);
        }
        for (int i = 0; i < len2; i++) {
            int len = Math.min(len1, len2 - i);
            int max = maxLength(nums1, nums2, 0, i, len);
            res = Math.max(res, max);
        }
        return res;
    }

    public static int maxLength(int[] nums1, int[] nums2, int a, int b, int len) {
        int res = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[a + i] == nums2[b + i])
                k++;
            else
                k = 0;
            res = Math.max(res, k);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5}, nums2 = {2, 3, 5, 6};
        System.out.println(findLength(nums1, nums2));
    }
}
