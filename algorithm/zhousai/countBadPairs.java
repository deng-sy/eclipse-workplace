package zhousai;
import java.util.*;
public class countBadPairs {
    public long countBadPairs(int[] nums) {
        long ans = getCnts(nums.length);
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= i;
        }
        HashMap<Integer, Long> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0l) + 1);
        }
        for (long cnt : map.values()) {
            if (cnt == 1)
                continue;
            ans -= getCnts(cnt);
        }
        return ans;
    }

    private long getCnts(long n) {
        return n * (n - 1) / 2;
    }
    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 3};
        System.out.println(new countBadPairs().countBadPairs(nums));
    }
}
