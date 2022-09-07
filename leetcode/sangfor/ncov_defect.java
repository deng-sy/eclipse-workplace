package sangfor;

public class ncov_defect {
    public int ncov_defect(int[][] grid) {
        // write code here
        if (grid.length == 0)
            return 0;

        int ans = 0;
        int n = grid.length, m = grid[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    continue;
                for (int[] dir : dirs) {
                    int ni = i + dir[0], nj = j + dir[1];
                    if (ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == 0 && !vis[ni][nj]) {
                        ans++;
                        vis[ni][nj] = true;
                    }
                }
            }
        }
        return ans;
    }
}
