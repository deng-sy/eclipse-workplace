package huawei;

import java.util.*;
public class StrMerge{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String str1=sc.next(),str2=sc.next();
        String merge=str1+str2;
        char[]ch=merge.toCharArray();
        int len=ch.length;
        char[]odd=new char[len/2],even=new char[len-len/2];
        System.out.println(len);
        for(int i=0,j=0,k=0;i<len;i++){
            if(i%2==1)
                odd[j++]=ch[i];
            else
                even[k++]=ch[i];
        }
        Arrays.sort(odd);
        Arrays.sort(even);
        Map<Character,Character> map = new HashMap<>() {{
            put('0', '0');
            put('1', '8');
            put('2', '4');
            put('3', 'C');
            put('4', '2');
            put('5', 'A');
            put('6', '6');
            put('7', 'E');
            put('8', '1');
            put('9', '9');
            put('a', '5');
            put('b', 'D');
            put('c', '3');
            put('d', 'B');
            put('e', '7');
            put('f', 'F');
            put('A', '5');
            put('B', 'D');
            put('C', '3');
            put('D', 'B');
            put('E', '7');
            put('F', 'F');
        }};
        for(int i=0,j=0,k=0;i<len;i++){
            if(i%2==1)
                ch[i]=map.getOrDefault(odd[j],odd[j++]);
            else
                ch[i]=map.getOrDefault(even[k],even[k++]);

        }
        System.out.println(new String(ch));

    }
}
