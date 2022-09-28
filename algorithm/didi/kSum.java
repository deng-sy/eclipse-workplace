package didi;
import java.util.*;
public class kSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt(),k=sc.nextInt();
            int[]nums=new int[n+1];
            for(int i=1;i<=n;i++)
                nums[i]=sc.nextInt();
            long[][]dp=new long[n+1][k+1];
            for(int i=0;i<=n;i++){
                dp[i][0]=1;
            }
            for(int j=1;j<=k;j++){
                dp[0][j]=0;
            }
            for(int i=1;i<=n;i++){
                for(int j=0;j<=k;j++){
                    if(nums[i]<=j)
                        dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i]];
                    else
                        dp[i][j]=dp[i-1][j];
                }
            }
            System.out.println(dp[n][k]);
        }
    }
}
