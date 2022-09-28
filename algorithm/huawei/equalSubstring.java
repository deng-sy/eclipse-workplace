package huawei;

import java.util.Arrays;

public class equalSubstring {
    public static int equalSubstring(String s, String t, int maxCost){
        int res=0;
        int n=s.length();
        int[]dist=new int[n];
        for(int i=0;i<n;i++){
            char ch1=s.charAt(i),ch2=t.charAt(i);
            dist[i]=Math.abs(ch1-ch2);
        }
        int start=0,end=0,sum=0;
        while(end<n){
            sum+=dist[end];
            while(sum>maxCost){
                sum-=dist[start];
                start++;
            }
            res=Math.max(res,end-start+1);
            end++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print(equalSubstring("krrgw","zjxss",19));
    }
}
