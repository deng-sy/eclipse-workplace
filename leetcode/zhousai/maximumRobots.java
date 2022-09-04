package zhousai;

import java.util.*;

public class maximumRobots {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int ans = 0;
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        long sum = 0L;
        // 枚举区间右端点 right，计算区间左端点 left 的最小值
        for (int left = 0, right = 0; right < chargeTimes.length; ++right) {
            // 及时清除队列中的无用数据，保证队列的单调性
            while (!q.isEmpty() && chargeTimes[right] >= chargeTimes[q.peekLast()])
                q.pollLast();
            q.addLast(right);
            sum += runningCosts[right];
            // 如果左端点 left 不满足要求，就不断右移 left
            while (!q.isEmpty() && chargeTimes[q.peekFirst()] + (right - left + 1) * sum > budget) {
                // 及时清除队列中的无用数据，保证队列的单调性
                if (q.peekFirst() == left)
                    q.pollFirst();
                sum -= runningCosts[left++];
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] chargeTimes = {11, 12, 19};
        int[] runningCosts = {10, 8, 7};
        int budget = 19;
        System.out.println(new maximumRobots().maximumRobots(chargeTimes, runningCosts, budget));
    }
}
