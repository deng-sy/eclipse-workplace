package meituan;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            int cnt=0;
            int[]cooked=new int[m];
            for(int i=0;i<m;i++)
                cooked[i]=sc.nextInt();
            int min=Math.min(a,b);
            int max=Math.max(a,b);
            Arrays.sort(cooked);

            if(min>cooked[0]||max<cooked[m-1])
                System.out.println("NO");
            else{
                if(min<cooked[0])
                    cnt++;
                if(max>cooked[m-1])
                    cnt++;
                if(m+cnt<=n)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }




    }
}
