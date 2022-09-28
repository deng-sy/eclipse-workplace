package zhousai;

import java.util.HashMap;

public class taskSchedulerII {
    public long taskSchedulerII(int[] tasks, int space) {
        space++;
        long ans = 0;
        HashMap<Integer, Long> map = new HashMap<>();
        for (int task : tasks) {
            if (map.getOrDefault(task, Long.MIN_VALUE) + space > ans) {
                ans = map.get(task) + space;
            } else {
                ans++;
            }
            map.put(task, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] tasks = {8};
        int space = 1;
        System.out.println(new taskSchedulerII().taskSchedulerII(tasks, space));
    }
}
