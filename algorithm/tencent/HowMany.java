package tencent;
import java.util.*;
public class HowMany {
    public int howMany (String S, int k) {
        Map<Character,Integer>map=new HashMap<>();
        char ch;
        Set<Character>set=new HashSet<>();
        for(int i=0;i<S.length();i++){
            ch=S.charAt(i);
            if(set.contains(ch))
                continue;
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch)==k){
                set.add(ch);
            }
        }
        return set.size();
    }
}
