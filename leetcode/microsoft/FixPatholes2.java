package microsoft;

import java.util.*;

public class FixPatholes2 {
    public int solution(int[] X, int[] Y, int W) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int x : X) {
            set.add(x);
        }
        int ans = 0;
        int range = -1;
        for (int x : set) {
            if (x <= range)
                continue;
            else {
                range = x + W;
                ans++;
            }

        }
        return ans;
    }
}
