package wangyi;

import java.util.Scanner;

public class Zero {
    public static int Zero(int[]nums){
        int res=0;
        int n=nums.length;
        int mult;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                mult=1;
                for(int k=j;k<=i;k++){
                    mult*=nums[k];
                }
                if(mult%10==0){
                    System.out.print(mult+" ");
                    res+=Math.log10(mult);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[]nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }
            System.out.print(Zero(nums));
        }
    }
}
