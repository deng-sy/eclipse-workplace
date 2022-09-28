package meituan;

import java.util.*;

public class MagicTakeOrder {
    public static int binarySearch(int[] deadlines, int left, int target) {
        int right = deadlines.length;
        int ans = left;
        while (left < right) {
            int mid = (left + right) / 2;
            if (deadlines[mid] >= target) {
                right--;
                ans = right;
            } else {
                left++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(), t = sc.nextInt();
            int[] deadlines = new int[n];
            for (int i = 0; i < n; i++) {
                deadlines[i] = sc.nextInt();
            }
            int ans = 0;
            int time = 0;
            Arrays.sort(deadlines);
            int i = 0;
            while (i < n) {
                time += t;
                int j = binarySearch(deadlines, i, time);
                ans += j - i;
                i = j + 1;
            }
            System.out.println(ans);
        }
    }
}
