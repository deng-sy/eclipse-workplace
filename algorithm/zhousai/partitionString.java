package zhousai;

//6177. ���ַ��������Ż���
//����һ���ַ��� s �����㽫���ַ������ֳ�һ������ ���ַ��� ��������ÿ�����ַ����е��ַ����� Ψһ �ġ�Ҳ����˵���ڵ������ַ����У���ĸ�ĳ��ִ����������� һ�� ��
//������ĿҪ�������£����� ���� ��Ҫ���ֶ��ٸ����ַ�����
//ע�⣬���ֺ�ԭ�ַ����е�ÿ���ַ���Ӧ��ǡ������һ�����ַ�����

import java.util.*;

public class partitionString {

    public int partitionString(String s) {
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        int idx = 0;
        while (idx < s.length()) {
            while (idx < s.length() && !set.contains(s.charAt(idx))) {
                set.add(s.charAt(idx));
                idx++;
            }
            set.clear();
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new partitionString().partitionString("abacaba"));
    }

}
