package duxiaoman;

import java.util.*;

public class Pstr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), p = sc.nextInt();
            String str = sc.next();
            int ans = 0;
            boolean[] vis = new boolean[n];
            for (int i = 0; i < p; i++) {
                if (vis[i])
                    continue;
                int[] chars = new int[26];
                int max = 0;
                int cnt = 0;
                for (int j = i; j < n; j += p) {
                    if (!vis[j]) {
                        char c1 = str.charAt(j);
                        chars[c1 - 'a']++;
                        max = Math.max(max, chars[c1 - 'a']);
                        vis[j] = true;
                        cnt++;
                    }
                    if (!vis[n - j - 1]) {
                        char c2 = str.charAt(n - j - 1);
                        chars[c2 - 'a']++;
                        max = Math.max(max, chars[c2 - 'a']);
                        vis[n - j - 1] = true;
                        cnt++;
                    }
                }
                ans += cnt - max;
            }
            System.out.println(ans);
        }
    }

}
