package dyn_pro;

public class maxProfit {
    //    ����һ�����飬���ĵ�i��Ԫ����һ֧�����Ĺ�Ʊ�ڵ�i��ļ۸����һ���㷨�����������ܻ�ȡ�����������������������ʽ��ס�
    public static int maxProfit(int[] prices){
////        ����dp[i][j]��ʾ��j�����֮����ཻ��i�����ܻ�õ��������
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
//        ��������״̬����һ�����룬��һ���������ڶ������룬�ڶ�������
        for(int i=1;i<prices.length;i++){
            buy1=Math.max(buy1,-prices[i]);
            sell1=Math.max(sell1,buy1+prices[i]);
            buy2=Math.max(buy2,sell1-prices[i]);
            sell2=Math.max(sell2,buy2+prices[i]);
        }
        return sell2;

    }
}
