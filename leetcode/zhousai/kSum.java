package zhousai;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//给你一个整数数组 nums 和一个 正 整数 k 。你可以选择数组的任一 子序列 并且对其全部元素求和。
//
//数组的 第 k 大和 定义为：可以获得的第 k 个 最大 子序列和（子序列和允许出现重复）
//
//返回数组的 第 k 大和 。
//
//子序列是一个可以由其他数组删除某些或不删除元素排生而来的数组，且派生过程不改变剩余元素的顺序。
//
//注意：空子序列的和视作 0 。
public class kSum {
    public long kSum(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> (int) (o2[0] - o1[0]));
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num < 0)
                nums[i] = -num;
            else
                sum += num;
        }
        Arrays.sort(nums);
        pq.offer(new long[]{sum, 0});
        while (--k > 0) {
//            System.out.println(pq.peek()[0]);
            long[] pair = pq.poll();
            long num = pair[0], idx = pair[1];
            if (idx == n)
                continue;
            pq.offer(new long[]{num - nums[(int) idx], idx + 1});
            if (idx > 0)
                pq.offer(new long[]{num - nums[(int) idx] + nums[(int) idx - 1], idx + 1});
        }
        return pq.peek()[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, -2};
        int k = 5;
        System.out.println(new kSum().kSum(nums, k));
    }
}
