package baidu;

import java.util.Scanner;

public class robot {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String order=sc.next();
            int left=0,right=0,up=0,down=0;
            int idx=0;
            while(idx<order.length()){
                char c=order.charAt(idx);
                if(c=='L')
                    left++;
                else if(c=='R')
                    right++;
                else if(c=='U')
                    up++;
                else if(c=='D')
                    down++;
            }
            int x=right-left,y=up-down;

        }
    }
}
