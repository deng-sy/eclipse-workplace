package Nums_String;

import java.util.*;

//给你一个字符串数组 words ，每个单词可以写成每个字母对应摩尔斯密码的组合。
public class uniqueMorseRepresentations {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
                ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> seen = new HashSet<>();
        for (String word : words) {
            StringBuilder code = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                code.append(morse[c - 'a']);
            }
            seen.add(code.toString());
        }
        return seen.size();
    }
}
