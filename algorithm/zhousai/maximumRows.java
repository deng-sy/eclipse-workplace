package zhousai;
/*
给你一个下标从 0开始的m x n二进制矩阵mat和一个整数cols，表示你需要选出的列数。
如果一行中，所有的 1 都被你选中的列所覆盖，那么我们称这一行 被覆盖了。
请你返回在选择 cols列的情况下，被覆盖的行数 最大为多少。
 */
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
