package xiaomi;

import java.util.*;

public class EnglishTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(), t = sc.next();
        System.out.println(minDistance(s, t));
    }

    static int minDistance(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if (len1 * len2 == 0)
            return len1 + len2;
        int[] dp = new int[len2 + 1];
        for (int i = 0; i <= len2; i++)
            dp[i] = i;
        int last;
        for (int i = 1; i <= len1; i++) {
            last = dp[0];
            dp[0] = i;
            for (int j = 1; j <= len2; j++) {
                int tmp = dp[j];
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[j] = last;
                else
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), last) + 1;
                last = tmp;
            }
        }
        return dp[len2];

    }
}
