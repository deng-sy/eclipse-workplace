package yuanfudao;

import java.util.*;

public class Park {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(), m = sc.nextInt();
            List<List<int[]>> list = new ArrayList<>();
            while (n-- > 0) {
                list.add(new ArrayList<>());
            }
            int start = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                int from = sc.nextInt(), to = sc.nextInt(), condition = sc.nextInt(), reward = sc.nextInt();
                list.get(from).add(new int[]{to, condition, reward});
                if (condition < min) {
                    min = condition;
                    start = from;
                }
            }
            int ans = 0;
            int cur = 0;
            boolean[] vis = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int from = queue.poll();
                    int minCost = Integer.MAX_VALUE;
                    int minIdx = -1;
                    for (int[] nums : list.get(from)) {
                        int to = nums[0], condition = nums[1], reward = nums[2];
                        if (condition < minCost) {
                            minCost = condition;
                            minIdx = to;
                        }
                    }
                    if (cur < minCost) {
                        ans += minCost - cur;
                    }
                    if (vis[minIdx])
                        break;
                }
            }
            System.out.println(ans);

        }
    }
}
