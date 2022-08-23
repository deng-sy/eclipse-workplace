package zhousai;

import java.util.ArrayList;
import java.util.Arrays;

public class secondsToRemoveOccurrences {
    public int secondsToRemoveOccurrences(String s) {
        int ans = 0, pre0 = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0')
                pre0++;
            else if (pre0 > 0)
                ans = Math.max(pre0, ans + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "0110101";
        System.out.println(new secondsToRemoveOccurrences().secondsToRemoveOccurrences(s));
    }
}
