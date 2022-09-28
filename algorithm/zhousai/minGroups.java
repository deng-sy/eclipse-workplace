package zhousai;

import java.util.*;

//6178. 将区间分为最少组数
//给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti] 表示 闭 区间 [lefti, righti] 。
//你需要将 intervals 划分为一个或者多个区间 组 ，每个区间 只 属于一个组，且同一个组中任意两个区间 不相交 。
//请你返回 最少 需要划分成多少个组。
//如果两个区间覆盖的范围有重叠（即至少有一个公共数字），那么我们称这两个区间是 相交 的。比方说区间 [1, 5] 和 [5, 8] 相交。
public class minGroups {
    //    差分
    public int minGroups1(int[][] intervals) {
        int[] cnt = new int[1000005];
        for (int[] interval : intervals) {
            cnt[interval[0]]++;
            cnt[interval[1] + 1]--;
        }
        int ans = 1;
        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];
            ans = Math.max(ans, cnt[i]);
        }
        return ans;
    }

    //堆
    public int minGroups2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        for (int[] interval : intervals) {
            int left = interval[0], right = interval[1];
            if (!pq.isEmpty() && pq.peek() < left) {
                pq.poll();
            }
            pq.offer(right);
        }
        return pq.size();
    }

}
