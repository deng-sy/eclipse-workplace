package Nums_String;
//给定一个长度为 n 的整数数组?nums?。
//假设?arrk?是数组?nums?顺时针旋转 k 个位置后的数组，我们定义?nums?的 旋转函数??F?为：
//F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
//返回?F(0), F(1), ..., F(n-1)中的最大值?

import java.util.Arrays;

//采用迭代
public class maxRotateFunction {
    public static int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int f = 0;
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }
        int res = f;
        for (int i = 0; i < n; i++) {
            f += sum - n * nums[n - i - 1];
            res = Math.max(res, f);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 6};
        System.out.print(maxRotateFunction(nums));
    }
}
