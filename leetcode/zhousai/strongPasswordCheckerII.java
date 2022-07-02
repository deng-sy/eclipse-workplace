package zhousai;
//如果一个密码满足以下所有条件，我们称它是一个 强?密码：
//
//它有至少 8?个字符。
//至少包含 一个小写英文?字母。
//至少包含 一个大写英文?字母。
//至少包含 一个数字?。
//至少包含 一个特殊字符?。特殊字符为："!@#$%^&*()-+"?中的一个。
//它 不?包含?2?个连续相同的字符（比方说?"aab"?不符合该条件，但是?"aba"?符合该条件）。
//给你一个字符串?password?，如果它是一个?强?密码，返回?true，否则返回?false?。

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class strongPasswordCheckerII {
//    正则法
    public static boolean strongPasswordCheckerII1(String password) {
        String pattern1="(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\-\\+]).{8,}";
        String pattern2="(.)\\1";
        return Pattern.compile(pattern1).matcher(password).find()&&!Pattern.compile(pattern2).matcher(password).find();
    }
//    模拟法
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
