package meituan;

import java.util.*;

public class LivingOnTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            int ans = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int idx = queue.poll();
                    if (idx * 2 + 1 < n) {
                        nums[idx * 2 + 1] += nums[idx];
                        queue.offer(idx * 2 + 1);
                    }
                    if (idx * 2 + 2 < n) {
                        nums[idx * 2 + 2] += nums[idx];
                        queue.offer(idx * 2 + 2);
                    }
                    ans = Math.max(ans, nums[idx]);
                }
            }
            System.out.println(ans);
        }
    }
}
