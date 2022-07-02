package hard;
//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

import java.util.Arrays;

public class reversePairs {
    public int reversePairs(int[] nums) {
        int len=nums.length;
        if(len<2)
            return 0;
        int[]copy= Arrays.copyOf(nums,nums.length);
        int[]tmp=new int[len];
        return reversePairs(copy,0,len-1,tmp);

    }
    private int reversePairs(int[]nums,int left,int right,int[]tmp){
        if(left==right)
            return 0;
        int mid=left+(right-left)/2;
        int leftPairs=reversePairs(nums,left,mid,tmp);
        int rightPairs=reversePairs(nums,mid+1,right,tmp);
        if(nums[mid]<=nums[mid+1])
            return leftPairs+rightPairs;
        int crossPairs=mergeAndCount(nums,left,mid,right,tmp);
        return leftPairs+rightPairs+crossPairs;
    }
    public int mergeAndCount(int[]nums,int left,int mid,int right,int[]tmp){
        for(int i=left;i<=right;i++){
            tmp[i]=nums[i];
        }
        int i=left;
        int j=mid+1;
        int cnt=0;
        for(int k=left;k<=right;k++){
            if(i==mid+1)
                nums[k]=tmp[j++];
            else if(j==right+1)
                nums[k]=tmp[i++];
            else if(tmp[i]<=tmp[j])
                nums[k]=tmp[i++];
            else{
                nums[k]=tmp[j++];
                System.out.println(cnt);
                cnt+=(mid-i+1);
            }

        }
        return cnt;

    }

    public static void main(String[] args) {
        reversePairs reversePairs=new reversePairs();
        System.out.println(reversePairs.mergeAndCount(new int[]{1,5,6,2,4,5},0,2,5,new int[6]));
    }
}
