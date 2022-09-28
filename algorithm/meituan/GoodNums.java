package meituan;

import java.util.Arrays;

public class GoodNums {
    public static int GoodNums(int[]nums){
        int sum=0;
        int len=nums.length;
        int mid=len>>1;
        for(int i=0;i<mid;i++){
            if(nums[i]>=nums[i+1]){
                sum-=nums[i+1];
                nums[i+1]=nums[i]+1;
                sum+=nums[i+1];
            }
        }
        for(int i=len-1;i>mid;i--){
            if(nums[i]>=nums[i-1]){
                sum-=nums[i-1];
                nums[i-1]=nums[i]+1;
                sum+=nums[i-1];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(GoodNums(new int[]{1,2,1,4,3}));
    }
}
