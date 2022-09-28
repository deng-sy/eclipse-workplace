package zhousai;
//����һ����Сд��ĸ��ɵ��ַ��� s ����һ������ k �����������������������Խ��ַ��� t ������
// �����ַ��� ��
//t ���ַ��� s ��һ�������С�
//t ��ÿ���� ���� ��ĸ����ĸ����λ�εľ��Բ�ֵС�ڻ���� k ��
//���� � �����ַ����ĳ��ȡ�

import java.util.*;

public class longestIdealString {
    public int longestIdealString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int[] dp = new int[s.length()];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            for (int j = 0; j <= k; j++) {
                char t1 = (char) (cur - j);
                char t2 = (char) (cur + j);
                if (map.containsKey(t1)) {
                    dp[i] = Math.max(dp[i], map.get(t1) + 1);
                }
                if (map.containsKey(t2)) {
                    dp[i] = Math.max(dp[i], map.get(t2) + 1);
                }
            }
            map.put(cur, dp[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "eduktdb";
        int k = 15;
        System.out.println(new longestIdealString().longestIdealString(s, k));
    }
}
