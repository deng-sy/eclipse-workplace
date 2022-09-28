package kedaxunfei;

import java.util.*;

public class AIPS {
    static int area;

    static void dfs(int[][] graph, boolean[][] vis, int i, int j) {
        vis[i][j] = true;
        area++;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = graph.length, n = graph[0].length;
        for (int[] dir : dirs) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni < 0 || ni >= m || nj < 0 || nj >= n || vis[ni][nj])
                continue;
            if (graph[ni][nj] != 0) {
                vis[ni][nj] = true;
                continue;
            }
            dfs(graph, vis, ni, nj);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] graph = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = graph[i][j] == sc.nextInt() ? 0 : 1;
            }
        }
        boolean[][] vis = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] != 0) {
                    vis[i][j] = true;
                    continue;
                }
                if (!vis[i][j]) {
                    area = 0;
                    dfs(graph, vis, i, j);
                    ans = Math.max(ans, area);
                }
            }
        }
        System.out.println(ans);

    }
}
