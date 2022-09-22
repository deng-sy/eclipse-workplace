package dyn_pro;

import java.util.Arrays;

public class numDistinct {
    //    给定一个字符串s和一个字符串t，计算在s的子序列中t出现的个数。
    public static int numDistinct(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int[][] dp = new int[tLength + 1][sLength + 1];
//        dp[i][j]表示t的前i个字符可以由s的前j个字符组成的个数
        for (int j = 0; j <= sLength; j++)
            dp[0][j] = 1;
        for (int i = 1; i <= tLength; i++) {
            for (int j = 1; j <= sLength; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else
                    dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[tLength][sLength];
    }


    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.println(numDistinct(s, t));
    }


}
