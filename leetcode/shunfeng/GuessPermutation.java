package shunfeng;

import java.util.Scanner;

//最坏情况猜排列
public class GuessPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            long ans = 0, max = 1, len = 1;
            while (max << 1 <= n) {
                ans += max * len;
                max <<= 1;
                len++;
            }
            ans += len * (n - max + 1);
            System.out.println(ans);
        }
    }
}
