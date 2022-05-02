package meituan;

import java.util.HashMap;
import java.util.Scanner;

//给你一个只包含小写字符的字符串s，你可以按任意顺序重排这个字符串中的字符，请问重排过后的字符串中，最多能有多少个’acbcca’子串？
//
//例如，字符串’dacbccab’中含1个’acbcca’子串，按其他方式重排后最多也只能包含1个’acbcca’子串；字符串’acbccaacccb’中含1个’acbcca’子串，但重排成’acbccacbcca’ 后包含了2个’acbcca’子串。
public class subString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String pattern="acbcca";
            String str=sc.next();
            char[]chars=str.toCharArray();
            HashMap<Character,Integer> map=new HashMap();
            for(char ch:chars){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            int cnt=0;
            int num_a=map.get('a');
            int num_b=map.get('b');
            int num_c=map.get('c');
            while(num_a>=2&&num_b>=1&&num_c>=3){
                num_a-=1;
                num_b-=1;
                num_c-=3;
                cnt++;
            }
            System.out.println(cnt);



        }
    }
}
