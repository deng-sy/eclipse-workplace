package DoublePointers;

import java.util.Arrays;

//给定一个包含红色、白色和蓝色，一共n个元素的数组，原地对它们进行排序，使得相
//同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//此题中，我们使用整数0、1和2分别表示红色、白色和蓝色。
public class sortColors {
    public static void sortColors(int[]nums){
        int left=0,right=nums.length-1;
        int idx=0;
        while(idx<=right){
            if(nums[idx]==0)
                swap(nums,left++,idx++);
            else if(nums[idx]==1)
                idx++;
            else if(nums[idx]==2)
                swap(nums,right--,idx);

        }
    }
    //    采用异或方式实现交换
    private static void swap(int[]array,int i,int j){
        if(i!=j){
            array[i]^=array[j];
            array[j]^=array[i];
            array[i]^=array[j];
        }
    }
    public static void main(String[] args) {
        int[]nums={2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
