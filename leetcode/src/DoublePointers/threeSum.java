package DoublePointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class threeSum {
//    ����һ������n������������nums���ж�nums���Ƿ��������Ԫ��a��b��c��ʹ��
//    a+b+c=0�������ҳ����к�Ϊ0�Ҳ��ظ�����Ԫ�顣
    public static List<List<Integer>>threeSum(int[]nums){
        List<List<Integer>>res=new LinkedList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            if(nums[i]>0)
                break;
            int left=i+1,right=nums.length-1,target=-nums[i];
            while(left<right){
                int sum=nums[left]+nums[right];
                if(sum==target){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right&&nums[left]==nums[left+1])
                        left++;
                    while(left<right&&nums[right]==nums[right-1])
                        right--;
                    left++;
                    right--;
                }else if(sum<target)
                    left++;
                else
                    right--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[]nums={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
