package zhousai;
//如果一个正整数每一个数位都是 互不相同 的，我们称它是 特殊整数 。
//
//给你一个 正 整数 n ，请你返回区间 [1, n] 之间特殊整数的数目。

import java.util.Arrays;
import java.util.HashSet;

public class countSpecialNumbers {
    public int countSpecialNumbers(int n) {
        if (n < 10)
            return n;
        int cnt = countDigit(n);
        int[] digits = getDigits(n, cnt);
        int ans = countNumbersWithUniqueDigits(cnt - 1);
        boolean[] vis = new boolean[10];
        for (int i = 0; i < cnt; i++) {
            int cur = i == 0 ? digits[i] - 1 : digits[i];//当前位可以选择的数字的个数，注意首位不能为0所以要减1
            for (int k = 0; k < i; k++) {
                if (digits[k] < digits[i])//如果前面的数字比当前的小，不能选这个数字
                    cur--;
            }
            for (int k = i; k < cnt - 1; k++) {//固定前i位，枚举所有可能组合
                cur *= (9 - k);
            }
            ans += cur;
            if (vis[digits[i]])//如果前面也出现过这个数字，就不用往后进行了，因为肯定不满足
                break;
            if (i == cnt - 1 && !vis[digits[i]])//如果到达了最后一位且前面没有出现过这个数字，那n本身也是符合条件的
                ans++;
            vis[digits[i]] = true;
        }
        return ans;
    }

    //不超过n位的无重复数字的数的个数
    int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 9;
        }
        int res = 9, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }
        return res;
    }

    int countDigit(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n /= 10;
        }
        return cnt;
    }

    private int[] getDigits(int n, int cnt) {
        int[] ret = new int[cnt];
        for (int i = cnt - 1; i >= 0; i--) {
            ret[i] = n % 10;
            n /= 10;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new countSpecialNumbers().countSpecialNumbers(500));
    }
}
