package baidu;

import java.util.Scanner;
public class shopping {
    private static int findMinIdx(int[]prices,boolean[]isSold,int day,int[]growths){
        int min=Integer.MAX_VALUE;
        int idx=0;
        for(int i=0;i<prices.length;i++){
            if(min>prices[i]+day*growths[i]&&isSold[i]==false){
                min=prices[i]+day*growths[i];
                idx=i;
            }
        }
        return idx;
    }
    private static int findMaxIdx(int[]prices,boolean[]isSold,int day,int[]growths){
        int max=Integer.MIN_VALUE;

        int idx=0;
        for(int i=0;i<prices.length;i++){
            if(max<prices[i]+day*growths[i]&&isSold[i]==false){
                max=prices[i]+day*growths[i];
                idx=i;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[]prices=new int[n];
            int[]growths=new int[n];
            for(int i=0;i<n;i++){
                prices[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                growths[i]=sc.nextInt();
            }
            int minCost=0;
            int[][]dp=new int[n][n];
            boolean[]isSold=new boolean[n];
            for(int i=(n-1)/2;i>=0;i--){
                if(i%2==1){
                    isSold[findMaxIdx(prices,isSold,i,growths)]=true;
                }
                int idx=findMinIdx(prices,isSold,i,growths);
                isSold[idx]=true;
                minCost+=prices[idx]+i*growths[idx];
                System.out.println(minCost);
            }
            System.out.println(minCost);
        }

    }
}
