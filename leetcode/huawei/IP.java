package huawei;

import java.util.*;
public class IP {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        String toBeEncoded=sc.nextLine();
        long toBeDecoded=sc.nextLong();
        System.out.println(encode(toBeEncoded));
        System.out.println(decode(toBeDecoded));

    }
    public static long encode(String toBeEncoded){
        String[]strs=toBeEncoded.split("\\.");
        long num;
        long res=0;
        for(int i=0;i<4;i++){
            num=Integer.valueOf(strs[i]);
            res+=num<<((3-i)*8);
        }
        return res;
    }
    public static String decode(long toBeDecoded){
        StringBuilder sb=new StringBuilder();
        long num;
        for(int i=0;i<4;i++){
            num=(toBeDecoded>>((3-i)*8))&255;
            sb.append(num);
            if(i!=3)
                sb.append(".");
        }
        return sb.toString();
    }

}