package zhousai;

import java.util.*;

public class idealArrays {
    public static int idealArrays(int n, int maxValue) {
        int mod=1000000007;
        int[][]dp=new int[n+1][maxValue+1];
        List<Integer>[]lists=new ArrayList[maxValue+1];
        Arrays.fill(dp[1],1);
        for(int i=1;i<=maxValue;i++){
            lists[i]=new ArrayList<>();
            for(int j=1;j*i<=maxValue;j++){
                lists[i].add(j*i);
            }
        }
        long ans=0;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=maxValue;j++){
                for(int num:lists[j]){
                    dp[i][j]=(dp[i][j]+dp[i-1][num])%mod;
                }
            }
        }
        for(int i=1;i<=maxValue;i++){
            ans=(ans+dp[n][i])%mod;
        }
        return (int) ans;
    }
    public static void main(String[] args) {
        System.out.println(idealArrays(2,5));
    }
}
