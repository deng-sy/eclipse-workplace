package wangyi;

import java.util.*;

public class BitsDelete {
    static int[][] dp;
    static int max_a, max_b, max, len_a, len_b;
    //DFS+状态dp
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.next(), b = sc.next();
            len_a = a.length();
            len_b = b.length();
            max_a = 1 << len_a;
            max_b = 1 << len_b;
            max = len_a + len_b;
            dp = new int[max_a][max_b];
            int ans = dfs(0, 0, a, b);
            if (ans == max)
                System.out.println(-1);
            else
                System.out.println(ans);
        }
    }

    static int dfs(int status_a, int status_b, String a, String b) {
        if (status_a == max_a - 1 || status_b == max_b - 1)
            return max;
        if (dp[status_a][status_b] != 0)
            return dp[status_a][status_b];
        int num_a = 0, num_b = 0;
        for (int i = 0; i < len_a; i++) {
            if (((status_a >> i) & 1) == 0)
                num_a = num_a * 10 + a.charAt(i) - '0';
        }
        for (int i = 0; i < len_b; i++) {
            if (((status_b >> i) & 1) == 0)
                num_b = num_b * 10 + b.charAt(i) - '0';
        }
        if (num_a == 0 || num_b == 0)
            return max;
        if (num_a % num_b == 0 || num_b % num_a == 0)
            return 0;
        int ans = max;
        for (int i = 0; i < len_a; i++) {
            if (((status_a >> i) & 1) == 1)
                continue;
            ans = Math.min(ans, dfs(status_a | (1 << i), status_b, a, b) + 1);
        }
        for (int i = 0; i < len_b; i++) {
            if (((status_b >> i) & 1) == 1)
                continue;
            ans = Math.min(ans, dfs(status_a, status_b | (1 << i), a, b) + 1);
        }
        dp[status_a][status_b] = ans;
        return ans;
    }
}
