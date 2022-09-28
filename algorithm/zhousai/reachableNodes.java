package zhousai;
//2368. 受限条件下可到达节点的数目
//现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。
//
//给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。另给你一个整数数组 restricted 表示 受限 节点。
//
//在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。
//
//注意，节点 0 不 会标记为受限节点。

import java.util.*;

public class reachableNodes {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        HashSet<Integer> banned = new HashSet<>();
        for (int node : restricted) {
            banned.add(node);
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (banned.contains(x) || banned.contains(y))
                continue;
            list.get(x).add(y);
            list.get(y).add(x);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int from = queue.poll();
                for (int to : list.get(from)) {
                    if (!set.contains(to))
                        queue.offer(to);
                    set.add(to);
                }
            }
        }
        return set.size();
    }
}
