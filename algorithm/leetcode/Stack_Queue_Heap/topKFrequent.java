package Stack_Queue_Heap;

import java.util.*;

public class topKFrequent {
    //    法一：堆（优先队列）
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), cnt = entry.getValue();
            if (pq.size() == k) {
                if (pq.peek()[1] < cnt) {
                    pq.poll();
                    pq.offer(new int[]{num, cnt});
                }
            } else {
                pq.offer(new int[]{num, cnt});
            }

        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = pq.poll()[0];
        }
        return ret;

    }
//    法二：快排
}
