package zhousai;

//2407. 最长递增子序列 II
//给你一个整数数组 nums 和一个整数 k 。
//
//找到 nums 中满足以下要求的最长子序列：
//
//子序列 严格递增
//子序列中相邻元素的差值不超过 k 。
//请你返回满足上述要求的 最长子序列 的长度。
//
//子序列 是从一个数组中删除部分元素后，剩余元素不改变顺序得到的数组。
public class lengthOfLIS {
    int[] max;//max[i]表示线断树第i个节点所表示的区间内的最长递增子数组的长度，最终结果为max[1]，即[1,max(nums)]内的结果

    public int lengthOfLIS(int[] nums, int k) {
        var u = 0;
        for (var x : nums) u = Math.max(u, x);
        max = new int[u * 4];
        for (var x : nums) {
            if (x == 1) modify(1, 1, u, 1, 1);//以1结尾的，最长递增子数组长度一定为1
            else {
                var res = 1 + query(1, 1, u, Math.max(x - k, 1), x - 1);//以x结尾的，最长递增子数组长度为[x-k,x-1]内的节点对应的最长递增子数组长度的最大值+1
                modify(1, 1, u, x, res);
            }
        }
        return max[1];
    }

    private void modify(int o, int l, int r, int idx, int val) {
        if (l == r) {
            max[o] = val;
            return;
        }
        var m = (l + r) / 2;
        if (idx <= m) modify(o * 2, l, m, idx, val);
        else modify(o * 2 + 1, m + 1, r, idx, val);
        max[o] = Math.max(max[o * 2], max[o * 2 + 1]);
    }

    // 返回区间 [L,R] 内的最大值
    private int query(int o, int l, int r, int L, int R) { // L 和 R 在整个递归过程中均不变，将其大写，视作常量
        if (L <= l && r <= R) return max[o];
        var res = 0;
        var m = (l + r) / 2;
        if (L <= m) res = query(o * 2, l, m, L, R);
        if (R > m) res = Math.max(res, query(o * 2 + 1, m + 1, r, L, R));
        return res;
    }


}
