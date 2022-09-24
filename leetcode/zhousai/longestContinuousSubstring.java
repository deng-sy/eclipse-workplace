package zhousai;

//6181. 最长的字母序连续子字符串的长度
public class longestContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        char pre = s.charAt(0);
        int ans = 1;
        int cur = 1;
        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == pre + 1) {
                cur++;
                ans = Math.max(ans, cur);
            } else {
                cur = 1;
            }
            pre = ch;
        }
        return ans;
    }
}
