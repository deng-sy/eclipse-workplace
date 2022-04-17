package dyn_pro;

import java.util.Arrays;

//最长递增序列
public class lengthOfLIS {
    public static int lengthOfLIS(int[]nums){
        int len=1,n=nums.length;
        if(n==0)
            return 0;
        int[]dp=new int[n+1];
        dp[len]=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>dp[len])
                dp[++len]=nums[i];
            else{
                int left=1,right=len,pos=0;
                while(left<=right){
                    int mid=(left+right)/2;
                    if(dp[mid]<nums[i]){
                        pos=mid;
                        left=mid+1;
                    }else
                        right=mid-1;
                }
                dp[pos+1]=nums[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return len;
    }

    public static void main(String[] args) {
        int[]nums={10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
