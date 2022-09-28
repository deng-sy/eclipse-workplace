package zhousai;

import java.util.Arrays;

public class checkDistances {
    public boolean checkDistances(String s, int[] distance) {
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pos[ch - 'a'] == -1) {
                pos[ch - 'a'] = i;
            } else {
                if (i - pos[ch - 'a'] - 1 != distance[ch - 'a'])
                    return false;
            }
        }
        return true;
    }
}
