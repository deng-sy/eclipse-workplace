package microsoft;

import java.util.*;

public class Subset {
    public int solution(int[] A, int M) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = A[0], max = A[0];
        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int size = map.size();
        int[] nums = new int[size];
        int idx = 0;
        for (int num : map.keySet()) {
            nums[idx++] = num;
        }
        int ans = 0;
        for (int i = 0; i < size; i++) {
            int num = nums[i];
            if (!map.containsKey(num))
                continue;
            int cur = 1;
            int tmp = num;
            while (num + M <= max) {
                if (map.containsKey(num + M)) {
                    cur += map.get(num + M);
                    map.remove(num + M);
                }
                num += M;
            }
            num = tmp;
            while (num - M >= min) {
                if (map.containsKey(num - M)) {
                    cur += map.get(num - M);
                    map.remove(num - M);
                }
                num -= M;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {-3, -2, 1, 0, 8, 7, 1};
        int M = 3;
        System.out.println(new Subset().solution(A, M));
    }
}
