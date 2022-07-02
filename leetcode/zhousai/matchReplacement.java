package zhousai;
import java.util.*;
//���������ַ���?s ��?sub?��ͬʱ����һ����ά�ַ�����?mappings ������?mappings[i] = [oldi, newi]?��ʾ����Խ�?sub?��������Ŀ��?oldi?�ַ��滻Ϊ?newi?��sub?��ÿ���ַ� ����?���滻����һ�Ρ�
//
//���ʹ�� mappings?�滻 0 ���������ɸ��ַ������Խ� sub?��� s?��һ�����ַ��������㷵��?true�����򷵻�?false?��
//
//һ�� ���ַ���?���ַ����������ǿյ��ַ����С�
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
