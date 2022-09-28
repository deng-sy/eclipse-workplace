package Nums_String;

import java.util.regex.*;

public class Regex {
    public static void main(String[] args) {
//        String regex="[1-9][0-9]{4,14}";//0不能开头，总共5-15位
//        String str="0656010713";^d+(.d+)?
//        System.out.println(str.matches(regex));
//        String regex="^\\d+(\\.\\d+)?";
////        String str="2.";
////        System.out.println(str.matches(regex));
        String content = "1950.5.10";
        String reg = "(\\d)+";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
