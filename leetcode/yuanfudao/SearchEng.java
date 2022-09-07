package yuanfudao;

import java.util.HashMap;
import java.util.Scanner;

public class SearchEng {
    private static boolean isMatch(String word, String banner) {
        if (word.length() != banner.length())
            return false;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (banner.charAt(i) == '?')
                continue;
            if (word.charAt(i) != banner.charAt(i))
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int M = sc.nextInt();
            while (M-- > 0) {
                int N = sc.nextInt();
                String[] words = new String[N];
                HashMap<String, Integer> map = new HashMap<>();
                for (int i = 0; i < N; i++) {
                    words[i] = sc.next().toLowerCase();
                    map.put(words[i], map.getOrDefault(words[i], 0) + 1);
                }
                int K = sc.nextInt();
                String[] banners = new String[K];
                for (int i = 0; i < K; i++) {
                    banners[i] = sc.next();
                    for (String word : map.keySet()) {
                        if (isMatch(word, banners[i]))
                            map.put(word,0);
                    }
                }
                int ans = 0;
                for (int cnt : map.values()) {
                    ans = Math.max(ans, cnt);
                }
                System.out.println(ans);
            }
        }
    }
}
