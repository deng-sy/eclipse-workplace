package didi;

import java.util.Arrays;
import java.util.Scanner;

public class jimu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt(),k=sc.nextInt();
            long mod=998244353;
            long[]ret=new long[k-1];
            Arrays.fill(ret,1);
            while(--n>0){
                long[]tmp=new long[k-1];
                for(int i=0;i<k-1;i++){
                    if(i>0)
                        tmp[i-1]=(tmp[i-1]+ret[i])%mod;
                    if(i<k-2)
                        tmp[i+1]+=(tmp[i+1]+ret[i])%mod;
                }
                ret=tmp;
            }
            long ans=0;
            for(int i=0;i<k-1;i++){
                ans=(ans+ret[i])%mod;
            }
            System.out.println(ans);
        }
    }
}
