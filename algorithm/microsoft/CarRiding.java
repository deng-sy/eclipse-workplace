package microsoft;

import java.util.*;

public class CarRiding {
    int ans = 0;

    public int solution(int[] A, int[] B) {
        int n = A.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int a = A[i], b = B[i];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        int[] nums = new int[n + 1];
        Arrays.fill(nums, 1);
        dfs(0, new boolean[n + 1], nums, list);
        return ans;
    }

    private void dfs(int parent, boolean[] vis, int[] nums, List<List<Integer>> list) {
        vis[parent] = true;
        for (int child : list.get(parent)) {
            if (vis[child])
                continue;
            dfs(child, vis, nums, list);
            ans += nums[child] % 5 == 0 ? nums[child] / 5 : nums[child] / 5 + 1;
            nums[parent] += nums[child];
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 9, 9, 9, 9, 7, 8}, B = {2, 0, 3, 1, 6, 5, 4, 0, 0};
        System.out.println(new CarRiding().solution(A, B));
    }
}
