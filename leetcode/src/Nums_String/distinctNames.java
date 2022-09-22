package Nums_String;

import java.util.*;

//����һ���ַ������� ideas ��ʾ�ڹ�˾����������ʹ�õ������б���˾�����������£�
//�� ideas ��ѡ�� 2 �� ��ͬ ���֣���Ϊ ideaA �� ideaB ��
//���� ideaA �� ideaB ������ĸ��
//����õ������������� �� ���� ideas �У���ô ideaA ideaB������ ideaA �� ideaB ���м���һ���ո�ָ�����һ����Ч�Ĺ�˾���֡�
//���򣬲���һ����Ч�����֡�
//���� ��ͬ ����Ч�Ĺ�˾���ֵ���Ŀ��
class distinctNames {
    public static long distinctNames(String[] ideas) {
        var group = new HashMap<String, Integer>();
        for (var s : ideas) {
            var t = s.substring(1);
            group.put(t, group.getOrDefault(t, 0) | 1 << (s.charAt(0) - 'a'));
        }
        var ans = 0L;
        var cnt = new int[26][26];
        System.out.println(group);
        for (var mask : group.values()) {
            System.out.print(mask+":");
            for (var i = 0; i < 26; i++) {
                if ((mask >> i & 1) == 0) {
                    for (var j = 0; j < 26; j++)
                        if ((mask >> j & 1) > 0) {
                            ++cnt[i][j];
                        }
                } else {
                    for (var j = 0; j < 26; j++)
                        if ((mask >> j & 1) == 0) {
                            ans += cnt[i][j];
                        }
                }
            }
            System.out.println(ans);
        }


        return ans * 2;
    }

    public static void main(String[] args) {
        String[] ideas = {"coffee", "donuts", "time", "toffee"};
        System.out.println(distinctNames(ideas));
    }
}
