package DoublePointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class threeSum {
//    ����һ������n������������nums���ж�nums���Ƿ��������Ԫ��a��b��c��ʹ��
//    a+b+c=0�������ҳ����к�Ϊ0�Ҳ��ظ�����Ԫ�顣
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
