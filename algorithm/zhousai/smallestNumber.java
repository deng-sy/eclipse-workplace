package zhousai;

import java.util.Arrays;

public class smallestNumber {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        char[] ans = new char[n + 1];
        int i = 0;
        char cur = '1';
        while (i < n) {
            if (i > 0 && pattern.charAt(i) == 'I')
                i++;
            while (i < n && pattern.charAt(i) == 'I')
                ans[i++] = cur++;
            int j = i;
            while (i < n && pattern.charAt(i) == 'D')
                i++;
            int k = i;
            while (k >= j)
                ans[k--] = cur++;
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        String pattern = "IIIDDD";
        System.out.println(new smallestNumber().smallestNumber(pattern));
    }
}
