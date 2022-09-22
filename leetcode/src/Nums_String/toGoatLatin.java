package Nums_String;

import java.util.*;
//����һ�������ɵ�����ɵľ���?sentence �����ʼ��ɿո�ָ���ÿ�����ʽ��ɴ�д��СдӢ����ĸ��ɡ�
//���㽫����ת��Ϊ ��ɽ�������ģ�Goat Latin������һ�������� ��������?- Pig Latin ���鹹���ԣ���ɽ�������ĵĹ������£�
//���������Ԫ����ͷ��'a', 'e', 'i', 'o', 'u'�����ڵ��ʺ����"ma"��
//���磬���� "apple" ��Ϊ "applema" ��
//��������Ը�����ĸ��ͷ��������Ԫ����ĸ�����Ƴ���һ���ַ��������ŵ�ĩβ��֮�������"ma"��
//���磬���� "goat" ��Ϊ "oatgma" ��
//���ݵ����ھ����е��������ڵ�����������������ͬ��������ĸ'a'�������� 1 ��ʼ��
//���磬�ڵ�һ�����ʺ���� "a" ���ڵڶ������ʺ���� "aa" ���Դ����ơ�
//���ؽ� sentence ת��Ϊɽ�������ĺ�ľ��ӡ�

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
