package zhousai;
//2369. 检查数组是否存在有效划分
//给你一个下标从 0 开始的整数数组 nums ，你必须将数组划分为一个或多个 连续 子数组。
//
//如果获得的这些子数组中每个都能满足下述条件 之一 ，则可以称其为数组的一种 有效 划分：
//
//子数组 恰 由 2 个相等元素组成，例如，子数组 [2,2] 。
//子数组 恰 由 3 个相等元素组成，例如，子数组 [4,4,4] 。
//子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1 。例如，子数组 [3,4,5] ，但是子数组 [1,3,5] 不符合要求。
//如果数组 至少 存在一种有效划分，返回 true ，否则，返回 false 。
import java.util.LinkedList;
import java.util.Queue;

public class validPartition {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] vis = new boolean[n];
        vis[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int idx = queue.poll();
                if (idx == n)
                    return true;
                if (idx < n - 1 && nums[idx + 1] == nums[idx] && !vis[idx + 1]) {
                    queue.offer(idx + 2);
                    vis[idx + 1] = true;
                    if (idx < n - 2 && nums[idx + 2] == nums[idx + 1] && !vis[idx + 2]) {
                        queue.offer(idx + 3);
                        vis[idx + 2] = true;
                    }
                }
                if (idx < n - 2 && nums[idx + 1] == nums[idx] + 1 && nums[idx + 2] == nums[idx] + 2 && !vis[idx + 2]) {
                    queue.offer(idx + 3);
                    vis[idx + 2] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {264480, 264481, 264482, 264483, 264484, 264485, 264486, 264487, 264488, 264489, 264490, 264491, 264492, 264493, 264494, 264495, 264496, 264497, 264498, 264499, 264500, 264501, 264502, 264503, 264504, 264505, 264506, 264507, 264508, 264509, 264510, 264511, 264512, 264513, 264514, 264515, 264516, 264517, 264518, 264519, 264520, 264521, 264522, 264523, 264524, 264525, 264526, 264527, 264528, 264529, 264530, 264480, 264480, 53048, 53049, 53050, 53051, 53052, 53053, 53054, 53055, 53056, 53057, 53058, 53059, 53060, 53061, 53062, 53063, 53064, 53065, 53066, 53067, 53068, 53069, 53070, 53071, 53072, 53073, 53074, 53075, 53076, 53077, 53078, 53079, 53080, 53081};
////        int[]nums={1,2,3,4,5,6,2,2,2};}////        int[]nums={1,2,3,4,5,6,2,2,2};
        System.out.println(new validPartition().validPartition(nums));
    }
}
