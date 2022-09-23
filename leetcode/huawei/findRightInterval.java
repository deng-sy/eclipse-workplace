package huawei;

import java.util.Arrays;
import java.util.Comparator;

public class findRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] starts = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }
        Arrays.sort(starts, Comparator.comparingInt(o -> o[0]));
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            int target = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (starts[mid][0] >= intervals[i][1]) {
                    target = starts[mid][1];
                    right = mid - 1;
                } else
                    left = mid + 1;
            }
            ans[i] = target;
        }
        return ans;
    }
}
