package meituan;

import java.util.*;

public class MagicStone {
    public int solution(int n, int[] a, int[] b) {
        HashMap<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            map1.put(a[i], map1.getOrDefault(a[i], 0) + 1);
            if (a[i] == b[i]) continue;
            map2.put(b[i], map1.getOrDefault(b[i], 0) + 1);
            set.add(a[i]);
            set.add(b[i]);
        }
        int ans = Integer.MAX_VALUE;
        int half = n % 2 == 0 ? n / 2 : n / 2 + 1;
        for (int num : set) {
            if (map1.getOrDefault(num, 0) >= half) return 0;
            if (map1.getOrDefault(num, 0) + map2.getOrDefault(num, 0)
                    >= half)
                ans = Math.min(ans, half - map1.getOrDefault(num, 0));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] a = {1, 5, 7, 5, 3}, b = {10, 5, 5, 9, 10};
        System.out.println(new MagicStone().solution(n, a, b));
    }
}
