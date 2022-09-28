package Nums_String;

import java.util.*;

//����һ���ַ������� words ��ÿ�����ʿ���д��ÿ����ĸ��ӦĦ��˹�������ϡ�
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
