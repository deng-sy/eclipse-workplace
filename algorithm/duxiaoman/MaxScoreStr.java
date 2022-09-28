package duxiaoman;

import java.util.*;

public class MaxScoreStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                String str = sc.next();
                int[] scores = new int[26];
                for (char ch : str.toCharArray()) {
                    scores[ch - 'a']++;
                }
                int min = str.length(), max = 0;
                for (int score : scores) {
                    if (score == 0)
                        continue;
                    min = Math.min(min, score);
                    max = Math.max(max, score);
                }
                ans = Math.max(ans, max - min);
            }
            System.out.println(ans);

        }
    }
}
