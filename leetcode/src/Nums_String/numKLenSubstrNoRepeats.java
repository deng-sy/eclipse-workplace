package Nums_String;
import java.util.*;
//找出所有长度为k的无重复字符子串的数量
public class numKLenSubstrNoRepeats {
    public static int numKLenSubstrNoRepeats(String s, int k){
        Set<Character>set=new HashSet<>();
        char[]chars=s.toCharArray();
        int n=chars.length;
        int ans=0;
        int right=0;
        for(int i=0;i<n;i++){
            if(i!=0)
                set.remove(chars[i-1]);
            while(right<n&&!set.contains(chars[right])){
                set.add(chars[right]);
                right++;
                if(set.size()==k){
                    ans++;
                    System.out.println(set);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numKLenSubstrNoRepeats("aaabfefuf",5));
    }
}
