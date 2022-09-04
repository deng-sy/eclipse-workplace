package jingdong;

import java.util.*;

public class NumSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            int max = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
                max = Math.max(max, nums[i]);
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            int[] dp = new int[max + 1];
            for (int i = 0; i <= max; i++) {
                dp[i] = i - 1;
            }
            dp[0] = 0;
            for (int i = 2; i <= max; i++) {
                for (int j = 1; i * j <= max; j++) {
                    dp[i * j] = Math.min(dp[i] + dp[j] + 1, Math.min(dp[i * j], dp[i * j - 1] + 1));
                }
            }
            System.out.println(Arrays.toString(dp));
            long ans = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey(), value = entry.getValue();
                ans += value * dp[key];
            }
            System.out.println(ans);
        }
    }
}
