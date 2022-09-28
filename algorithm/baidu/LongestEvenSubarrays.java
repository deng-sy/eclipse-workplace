package baidu;

import java.util.Scanner;

public class LongestEvenSubarrays {
    private static int jiecheng(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * jiecheng(n - 1);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            for (int j = 0; j < t; j++) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] nums = new int[n];
                for (int i = 0; i < n; i++)
                    nums[i] = sc.nextInt();
                int mod = 1000000007;
                int odd_cnt = 0, even_cnt = 0;
                for (int num : nums) {
                    if (num % 2 == 1)
                        odd_cnt++;
                    else
                        even_cnt++;
                }
                int res = 0;
                int m = 0;
                while (m <= Math.min(odd_cnt, k)) {
                    if (k - m > even_cnt) {
                        m += 2;
                        continue;
                    }
                    res += (jiecheng(odd_cnt) / (jiecheng(m) * jiecheng(odd_cnt - m))) * (jiecheng(even_cnt) / (jiecheng(k - m) * jiecheng(even_cnt - k + m)));
                    m += 2;
                }
                System.out.println(res % mod);
            }

        }
    }
}
