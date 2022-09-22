package mayi;

import java.util.*;

public class IntervalSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int j = 0; j < q; j++) {
            int op = sc.nextInt(), i = sc.nextInt(), x = sc.nextInt();
            if (op == 1) {
                nums[i - 1] = x;
            } else {
                int ans = 0;
                for (int k = 0; k < i; k++) {
                    if (nums[k] == x)
                        ans++;
                }
                System.out.println(ans);
            }
        }

    }
}
