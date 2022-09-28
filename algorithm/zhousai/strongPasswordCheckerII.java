package zhousai;
//���һ���������������������������ǳ�����һ�� ǿ?���룺
//
//�������� 8?���ַ���
//���ٰ��� һ��СдӢ��?��ĸ��
//���ٰ��� һ����дӢ��?��ĸ��
//���ٰ��� һ������?��
//���ٰ��� һ�������ַ�?�������ַ�Ϊ��"!@#$%^&*()-+"?�е�һ����
//�� ��?����?2?��������ͬ���ַ����ȷ�˵?"aab"?�����ϸ�����������?"aba"?���ϸ���������
//����һ���ַ���?password?���������һ��?ǿ?���룬����?true�����򷵻�?false?��

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class strongPasswordCheckerII {
//    ����
    public static boolean strongPasswordCheckerII1(String password) {
        String pattern1="(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\-\\+]).{8,}";
        String pattern2="(.)\\1";
        return Pattern.compile(pattern1).matcher(password).find()&&!Pattern.compile(pattern2).matcher(password).find();
    }
//    ģ�ⷨ
    public static boolean strongPasswordCheckerII2(String password) {
        int n=password.length();
        if(n<8)
            return false;
        boolean hasDigit=false,hasLower=false,hasUpper=false,hasSpecial=false;
        String special="!@#$%^&*()-+";
        Set<Character>set=new HashSet<>();
        for(int i=0;i<special.length();i++){
            set.add(special.charAt(i));
        }
        for(int i=0;i<n;i++){
            char ch=password.charAt(i);
            if(!hasDigit&&Character.isDigit(ch))
                hasDigit=true;
            if(!hasLower&&Character.isLowerCase(ch))
                hasLower=true;
            if(!hasUpper&&Character.isUpperCase(ch))
                hasUpper=true;
            if(!hasSpecial&&set.contains(ch))
                hasSpecial=true;
            if(i>0&&ch==password.charAt(i-1))
                return false;
        }
        return hasDigit&&hasLower&&hasUpper&&hasSpecial;
    }

    public static void main(String[] args) {
        String password="abcacs2H!";
        System.out.println(strongPasswordCheckerII2(password));
    }
}
