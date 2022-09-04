package zhousai;

public class longestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int ans = 1;
        for (int right = 0; right < n; right++) {
            for (int i = right - 1; i >= left; i--) {
                if ((nums[i] & nums[right]) != 0) {
                    left = i + 1;
                    break;
                }

            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {744437702, 379056602, 145555074, 392756761, 560864007, 934981918, 113312475, 1090, 16384, 33, 217313281, 117883195, 978927664};
        System.out.println(new longestNiceSubarray().longestNiceSubarray(nums));
    }
}
