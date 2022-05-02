package huawei;

import java.util.*;
public class Shopping{
    public static void main(String[]args){


        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(),m=sc.nextInt();
        int[]prices=new int[m],values=new int[m],weights=new int[m],depends=new int[m];
        ArrayList<Integer>[] rels=new ArrayList[m];
        for(int i=0;i<m;i++){
            rels[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            prices[i]=sc.nextInt()/10;
            values[i]=sc.nextInt();
            depends[i]=sc.nextInt()-1;
            weights[i]=prices[i]*values[i];
            if(depends[i]>=0){
                rels[depends[i]].add(i);
            }
        }
        int[]dp=new int[N/10+1];
        int sub1,sub2;
        int sub_size;
        for(int i=0;i<m;i++){
            for(int j=N/10;j>=1;j--){
                if(j>=prices[i]&&depends[i]==-1){
                    sub_size=rels[i].size();
                    dp[j] = Math.max(dp[j], dp[j - prices[i]] + weights[i]);
                    if(sub_size==1){
                        sub1=rels[i].get(0);
                        if(j>=prices[i]+prices[sub1])
                            dp[j]=Math.max(dp[j],dp[j-prices[i]-prices[sub1]]+weights[i]+weights[sub1]);
                    }else if(sub_size==2){
                        sub1=rels[i].get(0);
                        sub2=rels[i].get(1);
                        if(j>=prices[i]+prices[sub1])
                            dp[j]=Math.max(dp[j],dp[j-prices[i]-prices[sub1]]+weights[i]+weights[sub1]);
                        if(j>=prices[i]+prices[sub2])
                            dp[j]=Math.max(dp[j],dp[j-prices[i]-prices[sub2]]+weights[i]+weights[sub2]);
                        if(j>=prices[i]+prices[sub1]+prices[sub2])
                            dp[j]=Math.max(dp[j],dp[j-prices[i]-prices[sub1]-prices[sub2]]+weights[i]+weights[sub1]+weights[sub2]);
                    }

                }
            }
        }

        System.out.println(dp[N/10]*10);

    }
};