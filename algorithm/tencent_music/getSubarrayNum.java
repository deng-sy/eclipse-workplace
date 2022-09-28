package tencent_music;

import java.util.*;

public class getSubarrayNum {
    public int getSubarrayNum(ArrayList<Integer> a, int x) {
        // write code here
        int mod = 1000000007;
        int left = 0;
        int n = a.size();
        int[] num_2 = new int[n + 1], num_5 = new int[n + 1];//dp[i]表示以i为右端点的合法区间个数
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            num_2[i + 1] = num_2[i] + num_base(a.get(i), 2);
            num_5[i + 1] = num_5[i] + num_base(a.get(i), 5);
            while (Math.min(num_2[i + 1] - num_2[left], num_5[i + 1] - num_5[left]) >= x) {
                left++;
                cnt++;
            }
            ans = (ans + cnt) % mod;
        }
        return ans;
    }

    int num_base(int n, int base) {
        int ans = 0;
        while (n % base == 0) {
            n /= base;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] nums = {5, 2, 3, 50, 4};
        for (int num : nums) {
            list.add(num);
        }
        int x = 2;
        System.out.println(new getSubarrayNum().getSubarrayNum(list, x));
    }

}

