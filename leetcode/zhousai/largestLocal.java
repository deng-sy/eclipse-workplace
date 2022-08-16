package zhousai;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//局部矩阵的最大值
public class largestLocal {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] row_max = new int[n][n - 2];
        int[][] col_max = new int[n - 2][n - 2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] != o1[1] ? o2[1] - o1[1] : o2[0] - o1[0]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                pq.offer(new int[]{j, grid[i][j]});
            }
            row_max[i][0] = pq.peek()[1];
            for (int j = 3; j < n; j++) {
                pq.offer(new int[]{j, grid[i][j]});
                while (pq.peek()[0] <= j - 3)
                    pq.poll();
                row_max[i][j - 2] = pq.peek()[1];
            }
            pq.clear();
        }
        for (int j = 0; j < n - 2; j++) {
            for (int i = 0; i < 3; i++) {
                pq.offer(new int[]{i, row_max[i][j]});
            }
            col_max[0][j] = pq.peek()[1];
            for (int i = 3; i < n; i++) {
                pq.offer(new int[]{i, row_max[i][j]});
                while (pq.peek()[0] <= i - 3)
                    pq.poll();
                col_max[i - 2][j] = pq.peek()[1];
            }
            pq.clear();
        }
        return col_max;
    }

    public static void main(String[] args) {
        int[][] grid = {{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}};
        System.out.println(Arrays.deepToString(new largestLocal().largestLocal(grid)));
    }
}
