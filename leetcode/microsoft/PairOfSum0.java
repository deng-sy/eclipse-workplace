package microsoft;

import java.util.HashMap;

public class PairOfSum0 {
    public int solution(int[] A) {
        int max = 1000000000;
        long ans = 0;
        int n = A.length;
        int preSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            preSum += A[i];
            if (map.containsKey(preSum)) {
                ans += map.get(preSum);
            }
            if (ans > max)
                return -1;
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] A = {2, -2, 3, 0, 4, -7};
        System.out.println(new PairOfSum0().solution(A));
    }
}
