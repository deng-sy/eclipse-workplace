package Nums_String;

import java.util.Arrays;

public class nextPermutation {
    public static void nextPermutation(int[]nums){
        int i=nums.length-2;
        while(i>=0&&nums[i]>=nums[i+1])
            i--;
        if(i>=0){
            int j=nums.length-1;
            while(j>=0&&nums[i]>=nums[j])
                j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }
    private static void swap(int[]nums,int i,int j){
        if(i!=j){
            nums[i]^=nums[j];
            nums[j]^=nums[i];
            nums[i]^=nums[j];
        }
    }
    private static void reverse(int[]nums,int start){
        int left=start,right=nums.length-1;
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[]nums={1,2,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
