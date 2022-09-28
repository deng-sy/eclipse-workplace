package didi;

import java.util.*;
public class jinzhi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[]chars={'A','B','C','D','E','F'};
        while(sc.hasNext()){
            int m=sc.nextInt(),n=sc.nextInt();
            boolean sign=m>=0;
            m=Math.abs(m);
            StringBuilder sb=new StringBuilder();
            while(m>0){
                int tmp=m%n;
                if(tmp<10)
                    sb.append(tmp);
                else
                    sb.append(chars[tmp-10]);
                m/=n;
            }
            if(!sign)
                sb.append("-");
            System.out.println(sb.reverse().toString());

        }
    }
}