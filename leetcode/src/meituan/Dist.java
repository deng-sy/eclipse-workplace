package meituan;

import java.util.Scanner;

//��������n���㣬�����ұ�ŷֱ�Ϊ1,2,��,n��
//
//С����1�ŵ㣬С����n�ŵ㣬����Ҫѡ��һ������Ϊ���ǻ�ϵĵص㣬��������ѡ��ĵ�����С����С�ŵ����ϵ�ľ����ֵ����С��
//
//��������������С�ľ���
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
