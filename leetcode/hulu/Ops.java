package hulu;

import java.util.*;

public class Ops {
    public int findMinimumTurns(int[] nums) {
        // ÔÚÕâ?Ğ´´úÂë
        int ans = nums.length;
        int[] cnts = new int[5];

        for (int num : nums) {
            cnts[num]++;
        }
        // System.out.println(Arrays.toString(cnts));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int dist = (i + 5 - j) % 5;
                int op = cnts[j] * dist;
                if (op > 0)
                    pq.offer(op);
            }
            int cur = 0;
            while (pq.size() > 1) {
                int a = pq.poll(), b = pq.poll();
                a--;
                b--;
                if (a > 0)
                    pq.offer(a);
                if (b > 0)
                    pq.offer(b);
                cur++;
            }
            if (pq.size() == 1) {
                cur += pq.poll();
            }
            ans = Math.min(ans, cur);
        }
        // System.out.println(Arrays.toString(ops));
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        System.out.println(new Ops().findMinimumTurns(nums));
    }
}