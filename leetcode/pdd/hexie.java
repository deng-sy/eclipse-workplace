package pdd;

import java.util.*;
public class hexie{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[]nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }
            int ans=0;

            for(int i=0;i<n;i++){
                int sum=nums[i];
                if(sum%m==0)
                    ans++;
                for(int j=i+1;j<n;j++){
                    sum+=nums[j];
                    if(sum%m==0)
                        ans++;
                }
            }
            System.out.println(ans);
        }


    }
}

