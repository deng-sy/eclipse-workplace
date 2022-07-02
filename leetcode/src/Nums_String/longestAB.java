package Nums_String;
import java.util.*;
public class longestAB {
    public static int longestAB(String S){
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,0);
        int res=0,state=0;
        for(int i=1;i<=S.length();i++){
            if(S.charAt(i-1)=='A')
                state++;
            else
                state--;
            if(map.containsKey(state))
                res=Math.max(res,i-map.get(state));
            else
                map.put(state,i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestAB("BABAABBABA"));
//        String str="1.1.1.1";
//        System.out.println(str.replaceAll("\\.","[.]"));
    }
}
