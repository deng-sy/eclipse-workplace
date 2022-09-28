package Graph;

import java.util.*;
//给你一个下标从 0 开始的二维整数数组 grid ，数组大小为 m x n 。每个单元格都是两个值之一：
//0 表示一个 空 单元格，
//1 表示一个可以移除的 障碍物 。
//你可以向上、下、左、右移动，从一个空单元格移动到另一个空单元格。
//现在你需要从左上角?(0, 0) 移动到右下角 (m - 1, n - 1) ，返回需要移除的障碍物的 最小 数目。

public class minimumObstacles {
    public static int minimumObstacles(int[][] grid) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        dist[0][0] = 0;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> dist[a[0]][a[1]]));
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + grid[nx][ny];
                    queue.offer(new int[]{nx, ny});
                }
            }

        }
        return dist[m - 1][n - 1];

    }

    public static void main(String[] args) {

    }
}
