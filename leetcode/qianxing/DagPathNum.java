package qianxing;

import java.util.LinkedList;
import java.util.Queue;

public class DagPathNum {
    public int DagPathNum(int[][] nodes) {
        int n = nodes.length;
        int start = 0, end = n - 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int from = queue.poll();
                for (int to : nodes[from]) {
                    if (to == end)
                        ans++;
                    else
                        queue.offer(to);
                }
            }
        }
        return ans;
    }
}
