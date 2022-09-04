package yuanfudao;

import java.util.*;

//求数组中包含数字k的所有质因子的子数组的最小长度
public class PrimSubsets {
    private static HashMap<Integer, Integer> getPrims(int k) {
        HashMap<Integer, Integer> res = new HashMap<>();
        int i = 2;
        while (i <= k) {
            if (i == k) {
                res.put(i, res.getOrDefault(i, 0) + 1);
                break;
            } else if (k % i == 0) {
                res.put(i, res.getOrDefault(i, 0) + 1);
                k /= i;
            } else
                i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int k = sc.nextInt(), n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            HashMap<Integer, Integer> target = getPrims(k);
            HashMap<Integer, Integer> current = new HashMap<>();
            int left = 0;
            int ans = n;
            for (int right = 0; right < n; right++) {
                current.put(nums[right], current.getOrDefault(nums[right], 0) + 1);
                while (left <= right) {
                    if (!target.containsKey(nums[left]) || target.get(nums[left]) < current.get(nums[left]))
                        current.put(nums[left], current.get(nums[left]) - 1);
                    else
                        break;
                    left++;
                }
                boolean flag = true;
                for (int num : target.keySet()) {
                    if (current.getOrDefault(num, 0) < target.get(num)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans = Math.min(ans, right - left + 1);
                }
            }
            System.out.println(ans);
        }
    }
}
