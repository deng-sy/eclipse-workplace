package zhousai;

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
