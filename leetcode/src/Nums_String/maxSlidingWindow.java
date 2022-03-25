package Nums_String;

import java.lang.reflect.Array;
import java.util.*;

public class maxSlidingWindow {
//    优先队列
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
//    单调队列
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        System.out.println(deque);
        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }


    public static void main(String[] args) {
        int[]nums={1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow2(nums,3)));
//        Deque<Integer>deque=new LinkedList<>();
//        deque.offerLast(1);
//        deque.offerLast(2);
//        deque.offerLast(3);
//        deque.pollFirst();
//        System.out.println(deque);
    }



}
