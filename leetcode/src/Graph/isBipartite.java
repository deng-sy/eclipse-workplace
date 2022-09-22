package Graph;
//二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 。

//如果图是二分图，返回 true ；否则，返回 false 。

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class isBipartite {
    int[] label;
    int[][] graph;

    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        int n = graph.length;
        label = new int[n];
        Arrays.fill(label, -1);
        for (int i = 0; i < n; i++) {
            if (label[i] == -1) {
                label[i] = 0;
                if (!dfs(i))
                    return false;
            }
        }
        System.out.println(Arrays.toString(label));
        return true;
    }

    public boolean dfs(int i) {
        for (int j : graph[i]) {
            if (label[j] == -1) {
                label[j] = 1 - label[i];
                if (!dfs(j))
                    return false;
            } else if (label[i] == label[j])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1}, {0, 3}, {3}, {1, 2}};
        System.out.print(new isBipartite().isBipartite(graph));
    }
}
