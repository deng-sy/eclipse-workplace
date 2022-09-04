package zhousai;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class findSubarrays {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (!set.add(nums[i] + nums[i + 1]))
                return true;
        }
        return false;
    }
}
