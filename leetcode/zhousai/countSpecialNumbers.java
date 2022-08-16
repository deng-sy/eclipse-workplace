package zhousai;

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
            int cur = i == 0 ? digits[i] - 1 : digits[i];
            for (int k = 0; k < i; k++) {
                if (digits[k] < digits[i])
                    cur--;
            }
            for (int k = i; k < cnt - 1; k++) {
                cur *= (9 - k);
            }
            ans += cur;
            if (vis[digits[i]])
                break;
            if (i == cnt - 1 && !vis[digits[i]])
                ans++;
            vis[digits[i]] = true;
        }
        return ans;
    }

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
