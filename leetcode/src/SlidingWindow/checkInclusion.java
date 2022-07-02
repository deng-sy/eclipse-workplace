package SlidingWindow;

import java.util.Arrays;
import java.util.Map;

//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
//换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
public class checkInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int[]cnt1=new int[26],cnt2=new int[26];
        int m=s1.length(),n=s2.length();
        if(m>n)
            return false;
        for(int i=0;i<m;i++){
            cnt1[s1.charAt(i)-'a']++;
        }
        int r=0;
        while(r<m){
            cnt2[s2.charAt(r)-'a']++;
            r++;
        }
        if(check(cnt1,cnt2))
            return true;
        while(r<n){
            cnt2[s2.charAt(r-m)-'a']--;
            cnt2[s2.charAt(r)-'a']++;
            if(check(cnt1,cnt2))
                return true;
            r++;
        }
        return false;
    }
    private boolean check(int[]cnt1,int[]cnt2){
        for(int i=0;i<26;i++){
            if(cnt1[i]>cnt2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[]cnt1={1,1,2,0},cnt2={1,1,2,0};
        System.out.println(Arrays.equals(cnt1,cnt2));
    }
}
