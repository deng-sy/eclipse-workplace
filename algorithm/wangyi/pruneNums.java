package wangyi;

import java.util.Scanner;

public class pruneNums {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int p=sc.nextInt();
            int x=sc.nextInt();
            int[]nums=new int[n];
            int sum=0;
            int res=0;
            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
                sum+=nums[i];
            }
            int mod=sum%x;
            mod=mod==0?x:mod;
            for(int num:nums){
                int orig=num;
                int num_mod=num%x;
                int tmp=((num_mod-mod)+x)%x;
                if(num-mod<=0)
                    num+=x-mod;
                while(num-mod>0){
                    num-=x;
                }
                while(num<=p){
                    if(num!=orig){
                        res++;
                    }
                    num+=x;
                }
            }
            System.out.println(res);

        }
    }
}
