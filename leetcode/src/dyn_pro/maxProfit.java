package dyn_pro;

public class maxProfit {
    //    给定一个数组，它的第i个元素是一支给定的股票在第i天的价格。设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
    public static int maxProfit(int[] prices){
////        定义dp[i][j]表示在j天结束之后最多交易i次所能获得的最大利润。
//        int[][]dp=new int[3][prices.length];
//        for(int i=1;i<=2;i++){
//            for(int j=1;j<prices.length;j++){
//                for(int k=j-1;k>=0;k--){
//                    int max;
//                    if(k==0)
//                        max=Math.max(dp[i][j-1],prices[j]-prices[k]);
//                    else
//                        max=Math.max(dp[i][j-1],prices[j]-prices[k]+dp[i-1][k-1]);
//                    dp[i][j]=Math.max(dp[i][j],max);
//                }
//            }
//        }
//        return dp[2][prices.length-1];
//
        int buy1=-prices[0],sell1=0,buy2=-prices[0],sell2=0;
//        定义四种状态：第一次买入，第一次卖出，第二次买入，第二次卖出
        for(int i=1;i<prices.length;i++){
            buy1=Math.max(buy1,-prices[i]);
            sell1=Math.max(sell1,buy1+prices[i]);
            buy2=Math.max(buy2,sell1-prices[i]);
            sell2=Math.max(sell2,buy2+prices[i]);
        }
        return sell2;

    }
}
