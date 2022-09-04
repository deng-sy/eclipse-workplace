package zhousai;

import java.util.*;

public class maximumRobots {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int ans = 0;
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        long sum = 0L;
        // ö�������Ҷ˵� right������������˵� left ����Сֵ
        for (int left = 0, right = 0; right < chargeTimes.length; ++right) {
            // ��ʱ��������е��������ݣ���֤���еĵ�����
            while (!q.isEmpty() && chargeTimes[right] >= chargeTimes[q.peekLast()])
                q.pollLast();
            q.addLast(right);
            sum += runningCosts[right];
            // �����˵� left ������Ҫ�󣬾Ͳ������� left
            while (!q.isEmpty() && chargeTimes[q.peekFirst()] + (right - left + 1) * sum > budget) {
                // ��ʱ��������е��������ݣ���֤���еĵ�����
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
