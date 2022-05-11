package baidu;

import java.util.Scanner;

public class shopping2 {
    static int minCost=Integer.MAX_VALUE;
    static int cost=0;
    static int n=0;
    static int[]prices;
    static int[]growths;
    static boolean[]isSold;
    static boolean free;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            n=sc.nextInt();
            prices=new int[n];
            growths=new int[n];
            for(int i=0;i<n;i++){
                prices[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                growths[i]=sc.nextInt();
            }
            helper();
            System.out.println(minCost);
        }

    }
    private static void helper(){
        isSold=new boolean[n];
        backtrack(0);

    }
    private static int backtrack(int day){
        if(day>n/2){
            if(cost<minCost)
                minCost=cost;
            return minCost;
        }
        for(int i=0;i<n;i++){
            if(isSold[i])
                continue;
            else{
                if(day%2==1&&free){
                    free=false;
                    isSold[i]=true;
                    minCost=backtrack(day);
                    isSold[i]=false;
                }else{
                    free=true;
                    isSold[i]=true;
                    cost+=prices[i]+day*growths[i];
                    minCost=backtrack(day+1);
                    cost-=prices[i]+day*growths[i];
                    isSold[i]=false;
                }
            }
        }
        return minCost;
    }
}
