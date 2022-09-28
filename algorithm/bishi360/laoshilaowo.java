package bishi360;

import java.util.*;

public class laoshilaowo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(), p = sc.nextInt(), q = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));
            int ans = 0, score = 100;
            for (int i = n - 1; i >= 0; i--) {
                if (i < n - 1 && nums[i] < nums[i + 1])
                    score--;
                if (score * p + nums[i] * q < 6000)
                    break;
                ans++;
            }
            System.out.println(ans);
        }
    }
}
