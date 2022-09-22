package baidu;

import java.util.*;

public class BaiduSubString {
    static Set<Character> yuanyin = new HashSet<>();

    private static boolean check(String str, int idx) {
        boolean ans = true;
        boolean[] vis = new boolean[26];
        for (int j = 0; j < 5; j++) {
            char ch = str.charAt(idx + j);
            ans &= !vis[ch - 'a'];
            if (j == 0 || j == 3) {
                ans &= !yuanyin.contains(ch);
            } else
                ans &= yuanyin.contains(ch);
            if (!ans)
                return false;
            vis[ch - 'a'] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            String yuanyins = "aeiou";
            for (char ch : yuanyins.toCharArray())
                yuanyin.add(ch);
            long ans = 0;
            int idx = 0, len = str.length();
            while (idx < len - 4) {
                if (check(str, idx)) {
                    ans++;
                    System.out.println(str.substring(idx, idx + 5));
                    idx = idx + 3;
                } else
                    idx++;
            }
            System.out.println(ans);

        }
    }
}
