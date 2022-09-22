package Nums_String;

import java.util.*;

//给你一个字符串数组 ideas 表示在公司命名过程中使用的名字列表。公司命名流程如下：
//从 ideas 中选择 2 个 不同 名字，称为 ideaA 和 ideaB 。
//交换 ideaA 和 ideaB 的首字母。
//如果得到的两个新名字 都 不在 ideas 中，那么 ideaA ideaB（串联 ideaA 和 ideaB ，中间用一个空格分隔）是一个有效的公司名字。
//否则，不是一个有效的名字。
//返回 不同 且有效的公司名字的数目。
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
