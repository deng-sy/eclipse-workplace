package tencent;

import java.util.Arrays;
import java.util.Scanner;

public class Attack_Defend {
    public static int minGap(String strs){
        int n=strs.length();
        int[]nums=new int[n];
        int[]attack=new int[n];
        int[]defend=new int[n];
        for(int i=0;i<n;i++){
            nums[i]= strs.charAt(i)-48;
            if(nums[i]==0){
                attack[i]=i+1;
            }else{
                defend[i]=i+1;
            }
        }
        int res=Integer.MAX_VALUE;
        int left_sum,right_sum;
        for(int i=0;i<n;i++){
            right_sum=0;left_sum=0;
            for(int j=0;j<i;j++){
                left_sum+=attack[j];
            }
            for(int j=i;j<n;j++){
                right_sum+=defend[j];
            }
            res=Math.min(res,Math.abs(left_sum-right_sum));
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            String line=sc.next();
            System.out.println(minGap(line));
        }
    }
}
