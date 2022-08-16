package zhousai;
//给你一个由小写字母组成的字符串 s ，和一个整数 k 。如果满足下述条件，则可以将字符串 t 视作是
// 理想字符串 ：
//t 是字符串 s 的一个子序列。
//t 中每两个 相邻 字母在字母表中位次的绝对差值小于或等于 k 。
//返回 最长 理想字符串的长度。

import java.util.*;

public class longestIdealString {
    public int longestIdealString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int[] dp = new int[s.length()];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            for (int j = 0; j <= k; j++) {
                char t1 = (char) (cur - j);
                char t2 = (char) (cur + j);
                if (map.containsKey(t1)) {
                    dp[i] = Math.max(dp[i], map.get(t1) + 1);
                }
                if (map.containsKey(t2)) {
                    dp[i] = Math.max(dp[i], map.get(t2) + 1);
                }
            }
            map.put(cur, dp[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "eduktdb";
        int k = 15;
        System.out.println(new longestIdealString().longestIdealString(s, k));
    }
}
