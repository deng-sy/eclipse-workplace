package meituan;

import java.util.Scanner;

//数轴上有n个点，从左到右编号分别为1,2,…,n。
//
//小美在1号点，小团在n号点，现在要选择一个点作为他们会合的地点，他们期望选择的点能让小美和小团到达会合点的距离差值尽量小。
//
//你的任务是输出最小的距离差。
public class Dist {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[]nums=new int[n];
            for(int i=0;i<n;i++)
                nums[i]=sc.nextInt();
            int min=Integer.MAX_VALUE;
            for(int num:nums){
                min=Math.min(min,Math.abs((num-nums[0])-(nums[n-1]-num)));
            }
            System.out.println(min);
        }
    }
}
