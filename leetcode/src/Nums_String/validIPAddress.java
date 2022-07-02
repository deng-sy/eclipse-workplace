package Nums_String;

import java.util.HashSet;
import java.util.Set;

public class validIPAddress {
    public String validIPAddress(String queryIP) {
        int len=queryIP.length();
        String[]strs1=queryIP.split("\\.");
        String[]strs2=queryIP.split(":");
        int m=strs1.length,n=strs2.length;
        if(m==4&&queryIP.charAt(len-1)!='.')
            return checkIpv4(strs1);
        if(n==8&&queryIP.charAt(len-1)!=':')
            return checkIpv6(strs2);
        return "Neither";
    }
    private String checkIpv4(String[]strs){
        for(String str:strs){
            if(str.length()==0)
                return "Neither";
            int val=0;
            boolean flag=true;
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);

                if(Character.isDigit(ch)){
                    if(ch!='0')
                        flag=false;
                    if(ch=='0'&&flag&&i!=str.length()-1)
                        return "Neither";
                    val=val*10+ch-'0';
                    if(val>255)
                        return "Neither";
                }else
                    return "Neither";
            }
        }
        return "IPv4";

    }
    private String checkIpv6(String[]strs){
        String letters="0123456789abcdefABCDEF";
        char[]chars=letters.toCharArray();
        Set<Character> set=new HashSet<>();
        for(char ch:chars){
            set.add(ch);
        }
        for(String str:strs){
            if(str.length()==0||str.length()>4)
                return "Neither";
            for(int i=0;i<str.length();i++) {
                char ch = str.charAt(i);
                if (!set.contains(ch))
                    return "Neither";
            }
        }
        return "IPv6";

    }
}

