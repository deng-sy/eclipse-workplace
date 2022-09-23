package zhousai;

//6177. 子字符串的最优划分
//给你一个字符串 s ，请你将该字符串划分成一个或多个 子字符串 ，并满足每个子字符串中的字符都是 唯一 的。也就是说，在单个子字符串中，字母的出现次数都不超过 一次 。
//满足题目要求的情况下，返回 最少 需要划分多少个子字符串。
//注意，划分后，原字符串中的每个字符都应该恰好属于一个子字符串。

import java.util.*;

public class partitionString {

    public int partitionString(String s) {
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        int idx = 0;
        while (idx < s.length()) {
            while (idx < s.length() && !set.contains(s.charAt(idx))) {
                set.add(s.charAt(idx));
                idx++;
            }
            set.clear();
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new partitionString().partitionString("abacaba"));
    }

}
