package meituan;

import java.util.Arrays;
import java.util.Scanner;

//С��ϲ��7�ı�������������һЩ��Ƭ��ÿ�ſ�Ƭ�϶�ӡ��һ�����֣�С���������ѡһЩ��Ƭ��ʹ�ÿ�Ƭ�ϵ�����֮���������С����ϲ��7�ı�����
// ��ͬʱ��ϣ����ѡ���Ŀ�Ƭ������֮����7�ı���������������ѡ�����������֮���Ƕ��٣���ע�⣬С��Ҳ����һ�ſ�Ƭ������ѡ��
public class SevenTimes {
    static int maxSum=0;
//    ��ʱ
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
//      dp[i][j], ��¼��7ȡģΪj��ǰi�����ĺ͵����ֵ
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
