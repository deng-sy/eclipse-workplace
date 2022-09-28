package jingdong;

import java.util.Scanner;

public class Brick {
    static long[] factorial;
    static int mod=998244353;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        int res=0;
        int num_1;
        factorial =new long[n+1];
        factorial[0]=1;
        for(int i=1;i<=n;i++){
            factorial[i]=(factorial[i-1]*i)%mod;
        }
        for(int num_k=0;num_k<=n/k;num_k++){
            num_1=n-num_k*k;
            res+=combine(num_k+num_1,num_k);
            res%=mod;
        }
        System.out.println(res);
    }
    public static long combine(int n,int k){
        k=k<(n-k)?k:(n-k);
        int dividend=1;
        for(int i=n;i>n-k;i--){
            dividend*=i;
            dividend%=mod;
        }
        return dividend/ factorial[k];
    }
}
