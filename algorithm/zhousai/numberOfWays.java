package zhousai;

//给你两个 正 整数 startPos 和 endPos 。最初，你站在 无限 数轴上位置 startPos 处。在一步移动中，你可以向左或者向右移动一个位置。
//
//给你一个正整数 k ，返回从 startPos 出发、恰好 移动 k 步并到达 endPos 的 不同 方法数目。由于答案可能会很大，返回对 109 + 7 取余 的结果。
//
//如果所执行移动的顺序不完全相同，则认为两种方法不同。
//
//注意：数轴包含负整数。
public class numberOfWays {
    public int numberOfWays(int startPos, int endPos, int k) {
        int mod = 1000000007;
        int dist = endPos - startPos;
        if (k < Math.abs(dist) || ((k - dist) & 1) == 1) {
            return 0;
        }
        int cap = (k - Math.abs(dist)) >> 1;
        long[] dp = new long[cap + 1];
        dp[0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = cap; j >= 0; j--) {
                if (j >= 1)
                    dp[j] = (dp[j] + dp[j - 1]) % mod;
            }
        }
        return (int) dp[cap];
    }

    public static void main(String[] args) {
        System.out.println(new numberOfWays().numberOfWays(1, 2, 3));
    }
}
