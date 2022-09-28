package zhousai;
//给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。

//给你一个整数 k ，表示想要 连续 黑色块的数目。
//每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
//请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
public class minimumRecolors {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = blocks.charAt(i) == 'W' ? 0 : 1;
        }
        int left = 0;
        int ans = n;
        int cur = 0;
        for (int right = 0; right < k; right++) {
            cur += 1 - nums[right];
        }
        ans = Math.min(ans, cur);
        for (int right = k; right < n; right++) {
            if (nums[right] == 1)
                cur -= 1 - nums[left];
            else
                cur += nums[left];
            left++;
            ans = Math.min(ans, cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        String blocks = "BWWWBB";
        int k = 6;
        System.out.println(new minimumRecolors().minimumRecolors(blocks, k));
    }
}
