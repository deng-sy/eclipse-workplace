package pdd;

import java.util.*;
public class hexie{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int ans=0;
            int sum=0;
            int[]map=new int[m];
            map[0]=1;
            for(int i=0;i<n;i++){
                sum+=sc.nextInt();
                int res=sum%m;
                ans+=map[res];
                map[res]++;
            }
            System.out.println(ans);
        }


    }
}

