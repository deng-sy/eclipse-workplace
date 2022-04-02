package meituan;

import java.util.Arrays;
import java.util.Scanner;

//小美喜欢7的倍数。桌面上有一些卡片，每张卡片上都印有一个数字，小美想从中挑选一些卡片，使得卡片上的数字之和最大，由于小美很喜欢7的倍数，
// 她同时还希望挑选出的卡片的数字之和是7的倍数，请问她能挑选出的最大数字之和是多少？（注意，小美也可以一张卡片都不挑选）
public class SevenTimes {
    static int maxSum=0;
//    超时
    public static void backtrack(int[]nums,int curSum,int start){
        if(curSum%7==0&&curSum>maxSum){
            maxSum=curSum;
            return;
        }
        for(int i=start;i<nums.length;i++){
            curSum+=nums[i];
            backtrack(nums,curSum,i+1);
            curSum-=nums[i];
        }
    }


    public static int dym_pro(int n,int[]nums){
//      dp[i][j], 记录对7取模为j的前i个数的和的最大值
        int[][]dp=new int[n+1][7];
        for(int i=0;i<=n;i++)
            for(int j=0;j<7;j++)
                dp[i][j]=Integer.MIN_VALUE;
        dp[0][0]=0;

        for(int i=1;i<=n;i++){
            for(int j=0;j<7;j++){
                dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
                dp[i][j]=Math.max(dp[i][j],dp[i-1][Math.abs(j-nums[i])%7]+nums[i]);

            }


        }
        return dp[n][0];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            maxSum=0;
            int n=sc.nextInt();
            int[]nums=new int[n+1];
            for(int i=1;i<=n;i++)
                nums[i]=sc.nextInt();
            Arrays.sort(nums);
//            backtrack(nums,0,0);
            System.out.println(dym_pro(n,nums));

        }
    }
}
