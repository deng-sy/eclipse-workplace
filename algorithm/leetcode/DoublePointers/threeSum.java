package DoublePointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class threeSum {
//    给你一个包含n个整数的数组nums，判断nums中是否存在三个元素a，b，c，使得
//    a+b+c=0？请你找出所有和为0且不重复的三元组。
    public static List<List<Integer>>threeSum(int[]nums,int target){
        List<List<Integer>>res=new LinkedList<>();
        Arrays.sort(nums);
        for(int first=0;first<nums.length-2;first++){
            if(first>0&&nums[first]==nums[first-1])
                continue;
            if(nums[first]>target)
                break;
            int second=first+1,third=nums.length-1,new_target=target-nums[first];
            while(second<third){
                int sum=nums[second]+nums[third];
                if(sum==new_target){
                    res.add(Arrays.asList(nums[first],nums[second],nums[third]));
                    while(second<third&&nums[second]==nums[second+1])
                        second++;
                    while(second<third&&nums[third]==nums[third-1])
                        third--;
                    second++;
                    third--;
                }else if(sum<new_target)
                    second++;
                else
                    third--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[]nums={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums,-3));
    }
}
