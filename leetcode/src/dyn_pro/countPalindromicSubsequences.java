package dyn_pro;

/*
����һ���ַ��� s������ s �в�ͬ�ķǿա����������С����� ��
ͨ���� s ��ɾ�� 0 �������ַ�����������С�
���һ���ַ�����������ת����ַ�����һ�£���ô���ǡ������ַ����С���
�����ĳ�� i , ���� ai != bi ������������ a1, a2, ... �� b1, b2, ... ��ͬ��
ע�⣺������ܴܺ�����Ҫ�� 109 + 7 ȡģ ��
s[i] ������ 'a', 'b', 'c' �� 'd'
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
