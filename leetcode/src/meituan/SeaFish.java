package meituan;

import java.util.Arrays;

public class SeaFish {
    public static int splitArray(int[] nums) {
        //ini: sum, l, r
        int m=3;
        int max = nums[0]; int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }


        if (nums.length == 1) return sum;
        int l = max, r = sum;


        while (l <= r) {
            int mid = (l + r) / 2;
            if (noLongerThanM(mid, nums, m)) r = mid - 1;
            else l = mid + 1;
            System.out.printf("%d,%d\n",l,r);
        }

        return l;
    }

    public static boolean noLongerThanM(int value, int[] nums, int m) {
        int count = 1, sum = 0;

        for (int num : nums) {
            sum += num;
            if (sum > value) {
                sum = num;
                count++;
                if (count > m) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7,3,3,1,3}));
    }

}
