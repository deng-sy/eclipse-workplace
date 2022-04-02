package Nums_String;
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
public class lengthOfLIS {
    public static int lengthOfLIS(int[]nums){
        int len=1,n=nums.length;
        if(n==0)
            return 0;
        int[]d=new int[n+1];
        d[len]=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>d[len])
                d[++len]=nums[i];
            else{
                int left=1,right=len,pos=0;
                while(left<=right){
                    int mid=(left+right)>>1;
                    if(d[mid]<nums[i]){
                        pos=mid;
                        left=mid+1;
                    }else
                        right=mid-1;
                }
                d[pos+1]=nums[i];
            }
        }
        return len;
    }
}
