package DoublePointers;
//给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
public class numSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int l=0,r=0;
        int ans=0;
        int mul=1;
        while(r<n){
            mul*=nums[r];
            while(l<=r&&mul>=k){
                mul/=nums[l];
                l++;
            }
            ans+=r-l+1;
            r++;
        }
        return ans;

    }
}
