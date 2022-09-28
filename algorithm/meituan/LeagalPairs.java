package meituan;

import java.util.*;

public class LeagalPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int ans = 0;
            HashMap<Integer, Integer> map1 = new HashMap<>();
            HashMap<Integer, Integer> map2 = new HashMap<>();
            for (int j = 1; j < n - 1; j++) {
                for (int i = 0; i < j; i++) {
                    map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
                }
                for (int k = j + 1; k < n; k++) {
                    map2.put(nums[k], map1.getOrDefault(nums[k], 0) + 1);
                }
                for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                    int ni = entry.getKey(), cnt_i = entry.getValue();
                    if (map2.containsKey(3 * nums[j] - ni)) {
                        ans += cnt_i * map2.get(3 * nums[j] - ni);
                    }
                }
                map1.clear();
                map2.clear();
            }
            System.out.println(ans);
        }
    }

}
