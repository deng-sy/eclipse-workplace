package zhousai;

import java.util.*;

public class maximumRows {
    public int maximumRows(int[][] mat, int cols) {
        int m = mat.length, n = mat[0].length;
        int ans = 0;
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i] |= (1 << n - j - 1) * mat[i][j];
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < 1 << n; i++) {
            if (Integer.bitCount(i) != cols)
                continue;
            int cur = 0;
            for (int num : nums) {
                if ((num & i) == num)
                    cur++;
            }
            ans = Math.max(ans, cur);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 0, 1}};
        int cols = 2;
        System.out.println(new maximumRows().maximumRows(mat, cols));
    }
}
