package zhousai;

import java.util.Arrays;

//给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
//
//返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度  。
//
//子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
public class answerQueries {
    public int[] answerQueries(int[] nums, int[] queries) {
        int k = queries.length;
        int[] ans = new int[k];
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            int query = queries[i];
            int sum = 0;
            for (int num : nums) {
                sum += num;
                if (sum <= query)
                    ans[i]++;
                else
                    break;
            }
        }
        return ans;
    }
}
