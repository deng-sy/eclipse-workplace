package mayi;

import java.util.*;

public class CutStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        long ans = 0;
        int left = 0;
        for (int right = 1; right <= str.length(); right++) {
            while (left < right) {
                long num = Long.parseLong(str.substring(left, right));
                if (num < k) {
                    ans += right - left;
                    break;
                } else {
                    left++;
                }
            }
        }
        System.out.println(ans);

    }
}
