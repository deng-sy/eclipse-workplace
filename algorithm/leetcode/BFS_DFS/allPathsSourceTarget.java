package BFS_DFS;

import java.util.*;

public class allPathsSourceTarget {
    //    dfs
    int[][] graph;
    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int n;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        n = graph.length;
        dfs(0);
        return ret;
    }

    public void dfs(int i) {
        if (i == n - 1) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int j : graph[i]) {
            list.add(j);
            dfs(j);
            list.remove(list.size() - 1);
        }
    }
}
