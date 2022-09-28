package hard;

import java.util.HashMap;
import java.util.Map;

public class minWindow {
    public static String minWindow(String s, String t){
        int n=s.length(),m=t.length();
        if(n<m)
            return "";
        Map<Character,Integer>smap=new HashMap<>(),tmap=new HashMap<>();
        String ans="";
        int len=Integer.MAX_VALUE;
        int cnt=0;
        for(int i=0;i<m;i++){
            char ch=t.charAt(i);
            tmap.put(ch,tmap.getOrDefault(ch,0)+1);
        }
        for(int right=0,left=0;right<n;right++){
            char ch=s.charAt(right);
            smap.put(ch,smap.getOrDefault(ch,0)+1);
            if(tmap.containsKey(ch)&&smap.get(ch)<=tmap.get(ch))
                cnt++;
            System.out.println(left+" "+right);
            System.out.println(tmap);
            System.out.println(smap);
            while(left<right&&(!tmap.containsKey(s.charAt(left))||smap.get(s.charAt(left))>tmap.get(s.charAt(left)))){
                smap.put(s.charAt(left),smap.get(s.charAt(left))-1);
                left++;
            }
            if(cnt==m&&right-left+1<len){
                len=right-left+1;
                ans=s.substring(left,right+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "AB", t = "A";
        System.out.println(minWindow(s,t));

    }
}
