package zhousai;

import java.util.*;

public class decodeMessage {
    public static String decodeMessage(String key, String message) {
        int[]keys=new int[26];
        Arrays.fill(keys,-1);
        int seq=0;
        for(int i=0;i<key.length()&&seq<26;i++){
            if(key.charAt(i)==' ')
                continue;
            int idx=key.charAt(i)-'a';
            if(keys[idx]<0){
                keys[idx]=seq++;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<message.length();i++){
            char ch=message.charAt(i);
            if(ch==' '){
                sb.append(" ");
                continue;
            }
            sb.append((char)('a'+keys[ch-'a']));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String key="the quick brown fox jumps over the lazy dog";
        String msg="vkbs bs t suepuv";
        System.out.println(decodeMessage(key,msg));
    }
}
