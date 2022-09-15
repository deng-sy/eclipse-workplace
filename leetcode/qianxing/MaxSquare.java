package qianxing;

import java.util.Scanner;

public class MaxSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            int len = str.length();
            String[] strs = str.substring(1, len - 1).split(",");
            int n = strs.length;
            int ans = 0;
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            int left = 0, right = n - 1;
            while (left <= right) {
                if (nums[left] < nums[right]) {
                    ans = Math.max(ans, (right - left) * nums[left++]);
                } else
                    ans = Math.max(ans, (right - left) * nums[right--]);
            }
            System.out.println(ans);
        }
    }
}
