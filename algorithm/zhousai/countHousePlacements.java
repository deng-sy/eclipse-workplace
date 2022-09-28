package zhousai;

import java.util.Arrays;

//一条街道上共有 n * 2 个 地块 ，街道的两侧各有 n 个地块。每一边的地块都按从 1 到 n 编号。每个地块上都可以放置一所房子。
//
//现要求街道同一侧不能存在两所房子相邻的情况，请你计算并返回放置房屋的方式数目。由于答案可能很大，需要对 109 + 7 取余后再返回。
//
//注意，如果一所房子放置在这条街某一侧上的第 i 个地块，不影响在另一侧的第 i 个地块放置房子。
public class countHousePlacements {
    public static int countHousePlacements(int n) {
        int mod = 1000000007;
        long[] num = new long[4];
        Arrays.fill(num, 1);
        while (--n > 0) {
            long[] tmp = new long[4];
            tmp[0] = (num[0] + num[1] + num[2] + num[3]) % mod;
            tmp[1] = (num[0] + num[2]) % mod;
            tmp[2] = (num[0] + num[1]) % mod;
            tmp[3] = num[0] % mod;
            num = tmp;
        }
        long ans = 0;
        for (int i = 0; i < 4; i++) {
            ans = (ans + num[i]) % mod;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(countHousePlacements(3));
    }
}
