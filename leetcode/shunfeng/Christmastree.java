package shunfeng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//b-zero tree
public class Christmastree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }
            for (int i = 2; i <= n; i++) {
                int parent = sc.nextInt();
                list.get(parent).add(i);
            }
            int[] nums = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                nums[i] = sc.nextInt();
            }
            long[] add = new long[n + 1], del = new long[n + 1];
            dfs(1, nums, add, del, list);
            System.out.println(add[1] + del[1]);
        }
    }

    private static void dfs(int parent, int[] nums, long[] add, long[] del, List<List<Integer>> list) {
        for (int child : list.get(parent)) {
            dfs(child, nums, add, del, list);
            add[parent] = Math.max(add[parent], add[child]);
            del[parent] = Math.max(del[parent], del[child]);
        }
        nums[parent] += add[parent] - del[parent];
        if (nums[parent] > 0)
            del[parent] += nums[parent];
        else
            add[parent] -= nums[parent];
    }
}
