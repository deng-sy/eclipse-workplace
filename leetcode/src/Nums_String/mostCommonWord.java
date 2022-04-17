package Nums_String;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.*;

public class mostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String[]strs=paragraph.split("[\\p{IsPunctuation}\\p{IsWhite_Space}]+");
        for(int i=0;i<strs.length;i++){
            strs[i]=strs[i].toLowerCase();
        }
        Map<String,Integer>map=new HashMap<>();
        List<String>banned_list=Arrays.asList(banned);
        String max_str=null;
        int max_cnt=0;
        for(String str:strs){
            if(!banned_list.contains(str)){
                map.put(str,map.getOrDefault(str,0)+1);
                if(max_cnt<map.get(str)){
                    max_cnt=map.get(str);
                    max_str=str;
                }
            }

        }
        return max_str;

    }

    public static void main(String[] args) {
        String paragraph="Bob hit a ball, the hit BALL flew far after it was hit.";
        String[]banned={"hit"};
        System.out.print(mostCommonWord(paragraph,banned));
    }
}
