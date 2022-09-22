package Graph;

import java.util.*;
//����һ���±�� 0 ��ʼ�Ķ�ά�������� grid �������СΪ m x n ��ÿ����Ԫ��������ֵ֮һ��
//0 ��ʾһ�� �� ��Ԫ��
//1 ��ʾһ�������Ƴ��� �ϰ��� ��
//��������ϡ��¡������ƶ�����һ���յ�Ԫ���ƶ�����һ���յ�Ԫ��
//��������Ҫ�����Ͻ�?(0, 0) �ƶ������½� (m - 1, n - 1) ��������Ҫ�Ƴ����ϰ���� ��С ��Ŀ��

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
