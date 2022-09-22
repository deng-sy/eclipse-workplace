package Nums_String;

import java.util.*;
//给你一个由若干单词组成的句子?sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
//请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文?- Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
//如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
//例如，单词 "apple" 变为 "applema" 。
//如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
//例如，单词 "goat" 变为 "oatgma" 。
//根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
//例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
//返回将 sentence 转换为山羊拉丁文后的句子。

import java.util.HashSet;

public class toGoatLatin {
    public static String toGoatLatin(String sentence) {
        String[] sen = sentence.split(" ");
        char[] vowel = {'a', 'o', 'u', 'i', 'e'};
        Set<Character> set = new HashSet();
        for (char ch : vowel) {
            set.add(ch);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sen.length; i++) {
            char first = sen[i].toLowerCase().charAt(0);
            if (set.contains(first))
                sb.append(sen[i]);
            else
                sb.append(sen[i].substring(1)).append(sen[i].charAt(0));
            sb.append("ma");
            int cnt = i;
            while (cnt >= 0) {
                sb.append("a");
                cnt--;
            }
            if (i != sen.length - 1)
                sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.print(toGoatLatin("over"));
    }
}
