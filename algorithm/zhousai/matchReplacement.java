package zhousai;
import java.util.*;
//给你两个字符串?s 和?sub?。同时给你一个二维字符数组?mappings ，其中?mappings[i] = [oldi, newi]?表示你可以将?sub?中任意数目的?oldi?字符替换为?newi?。sub?中每个字符 不能?被替换超过一次。
//
//如果使用 mappings?替换 0 个或者若干个字符，可以将 sub?变成 s?的一个子字符串，请你返回?true，否则返回?false?。
//
//一个 子字符串?是字符串中连续非空的字符序列。
public class matchReplacement {
    Map<Character,Set<Character>>map=new HashMap<>();
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        int n=s.length(),m=sub.length();
        if(n<m)
            return false;

        for(char[]mapping:mappings){
            char ch0=mapping[0],ch1=mapping[1];
            if(map.get(ch0)==null){
                map.put(ch0,new HashSet<>());
            }
            map.get(ch0).add(ch1);
        }
        for(int i=0;i<n-m+1;i++){
            if(strStr(s.substring(i,i+m),sub))
                return true;
        }
        return false;
    }
    private boolean strStr(String haystack, String needle) {
        if(needle.isEmpty())
            return true;
        int n=needle.length();
        for(int i=0;i<n;i++){
            if(!match(haystack.charAt(i),needle.charAt(i)))
                return false;
        }
        return true;

    }
    private boolean match(char ch1,char ch2){
        return ch1==ch2||map.getOrDefault(ch2,new HashSet<>()).contains(ch1);
    }
}
