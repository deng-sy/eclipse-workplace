package DoublePointers;
//����һ������������ nums������ k �����ҳ��������ڳ˻�С�� k ��������������ĸ�����
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
