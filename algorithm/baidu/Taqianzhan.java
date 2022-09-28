package baidu;

import java.util.*;

public class Taqianzhan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] monsters = new int[n];
            for (int i = 0; i < n; i++)
                monsters[i] = sc.nextInt();
            long ans = 0;
            int[] dp = new int[n];
            for (int i = 0; i < n - 2; i++) {
                int cnt = Math.min(monsters[i], Math.min(monsters[i + 1] / 2, monsters[i + 2] / 3));
                dp[i] = Math.max(dp[i], cnt);
                dp[i + 1] = Math.max(dp[i + 1], cnt);
                dp[i + 2] = Math.max(dp[i + 2], cnt);
            }
            for (int i = 0; i < n; i++) {

            }
            for (int i = 0; i < n - 2; i++) {
                if (monsters[i] >= 1 && monsters[i + 1] >= 2 && monsters[i + 2] >= 3) {
                    long cnt = Math.min(monsters[i], Math.min(monsters[i + 1] / 2, monsters[i + 2] / 3));
                    ans += 5L * cnt;
                    monsters[i] -= cnt;
                    monsters[i + 1] -= cnt * 2;
                    monsters[i + 2] -= cnt * 3;
                }
                ans += monsters[i];
            }
            ans += monsters[n - 2] + monsters[n - 1];
            System.out.println(ans);

        }
    }
}
