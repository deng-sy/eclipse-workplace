package microsoft;

import java.util.*;

public class Filter {
    public int solution(int[] A) {
        int ans = 0;
        int n = A.length;
        double[] nums = new double[n];
        double sum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>((o1, o2) -> (int) (o2 - o1));
        for (int i = 0; i < n; i++) {
            nums[i] = A[i];
            sum += nums[i];
            pq.offer(nums[i]);
        }
        double pollution = 0;
        while (pollution < sum / 2) {
            double num = pq.poll();
            pollution += num / 2;
            pq.offer(num / 2);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {5, 10, 5};
        System.out.println(new Filter().solution(A));
    }
}
