package zhousai;

import java.util.Arrays;

public class longestCycle {
    int ans = -1;

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i])
                continue;
            int[] step = new int[n];
            step[i] = 1;
            dfs(vis, edges, i, step);
            if (ans >= n - i)
                break;
        }
        return ans;
    }

    private void dfs(boolean[] vis, int[] edges, int i, int[] step) {
        vis[i] = true;
        int target = edges[i];
        if (target == -1)
            return;
        if (step[target] > 0) {
            ans = Math.max(ans, step[i] - step[target] + 1);
            return;
        }
        if (vis[target])
            return;
        step[target] = step[i] + 1;
        dfs(vis, edges, target, step);
    }

    public static void main(String[] args) {
        int[] edges = {3, 3, 4, 2, 3};
        System.out.println(new longestCycle().longestCycle(edges));
    }

}
