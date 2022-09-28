package dyn_pro;

/*
给定一个字符串 s，返回 s 中不同的非空「回文子序列」个数 。
通过从 s 中删除 0 个或多个字符来获得子序列。
如果一个字符序列与它反转后的字符序列一致，那么它是「回文字符序列」。
如果有某个 i , 满足 ai != bi ，则两个序列 a1, a2, ... 和 b1, b2, ... 不同。
注意：结果可能很大，你需要对 109 + 7 取模 。
s[i] 仅包含 'a', 'b', 'c' 或 'd'
 */
public class countPalindromicSubsequences {
    public static int countPalindromicSubsequences(String s) {
        int n = s.length();
        int mod = (int) Math.pow(10, 9) + 7;
        int[][][] dp = new int[4][n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    char c = (char) ('a' + k);
                    if (j == i) {
                        if (s.charAt(i) == c)
                            dp[k][i][j] = 1;
                        else
                            dp[k][i][j] = 0;
                    } else {
                        if (s.charAt(i) != c)
                            dp[k][i][j] = dp[k][i + 1][j];
                        else if (s.charAt(j) != c)
                            dp[k][i][j] = dp[k][i][j - 1];
                        else {
                            if (j == i + 1)
                                dp[k][i][j] = 2;
                            else {
                                dp[k][i][j] = 2;
                                for (int m = 0; m < 4; m++) {
                                    dp[k][i][j] += dp[m][i + 1][j - 1];
                                    dp[k][i][j] %= mod;
                                }
                            }
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int k = 0; k < 4; k++) {
            ans += dp[k][0][n - 1];
            ans %= mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.print(countPalindromicSubsequences("bccb"));
    }
}
