package microsoft;

import java.util.Arrays;

public class FixPotholes {
    public int solution(String S, int B) {
        int n = S.length();
        int cnt = 0;
        int[] nums = new int[n];
        int r = 0, l = 0;
        while (r < n) {
            char ch = S.charAt(r);
            if (ch == '.') {
                if (l != r) {
                    nums[cnt++] = r - l;
                    l = r;
                }
                r++;
                l++;
                continue;
            }
            r++;
            if (r == n) {
                nums[cnt++] = r - l;
            }
        }
        int[] new_nums = Arrays.copyOf(nums, cnt);
        System.out.println(Arrays.toString(new_nums));
        Arrays.sort(new_nums);
        int ans = 0;
        for (int i = cnt - 1; i >= 0; i--) {
            int num = new_nums[i];
            if (num >= B) {
                ans += (B - 1);
                break;
            }
            B -= (num + 1);
            ans += num;
        }
        return ans;
    }

    public static void main(String[] args) {
        String S = "..";
        int B = 5;
        System.out.println(new FixPotholes().solution(S, B));
    }
}
