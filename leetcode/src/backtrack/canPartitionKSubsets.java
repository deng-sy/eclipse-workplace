package backtrack;

import java.util.Arrays;

public class canPartitionKSubsets {
//    给定一个整数数组nums和一个正整数k，找出是否有可能把这个数组分成k 个非空子集，其总和都相等
    public static boolean canPartitionKSubsets(int[]nums,int k){
        int total=0;
        for(int num:nums)
            total+=num;
        if(total==0||total%k!=0)
            return false;
        Arrays.sort(nums);
        return backtrack(nums,nums.length-1,total/k,new int[k]);
    }

    private static boolean backtrack(int[]nums,int idx,int target,int[]size){
        if(idx==-1){
            for(int i=1;i<size.length;i++){
                if(size[i]!=size[i-1])
                    return false;
            }

            return true;
        }

//        {1,5,3,3}
        for(int i=0;i<size.length;i++){
            System.out.println("i:"+i);
            System.out.println("size[i]:"+size[i]);
            System.out.println("idx:"+idx);
            System.out.println("nums[idx]:"+nums[idx]);
            System.out.println();
            if(size[i]+nums[idx]>target||(i>0&&size[i]==size[i-1]))
                continue;
            size[i]+=nums[idx];
            if(backtrack(nums,idx-1,target,size))
                return true;
            size[i]-=nums[idx];
            System.out.println(Arrays.toString(size));
        }


        return false;
    }

    public static void main(String[] args) {
        int[]nums={1,4,5,9,13};
        int k=4;
        System.out.println(canPartitionKSubsets(nums,k));
    }
}
