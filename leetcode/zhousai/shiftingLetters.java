package zhousai;

import java.util.HashSet;
import java.util.Objects;

public class shiftingLetters {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] changes = new int[n + 1];
        for (int[] shift : shifts) {
            int begin = shift[0], end = shift[1], dir = shift[2] == 1 ? 1 : -1;
            changes[begin] += dir;
            changes[end + 1] -= dir;
        }
        for (int i = 1; i <= n; i++) {
            changes[i] += changes[i - 1];
        }
        for (int i = 0; i < n; i++) {
            chars[i] = (char) (((chars[i] - 'a' + changes[i]) % 26 + 26) % 26 + 'a');
        }
        return new String(chars);
    }

}
