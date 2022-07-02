package Nums_String;

public class maxSubArray {
    public static int maxSubArray(int[] nums) {
        if(nums.length==0)
            return 0;
        int len=nums.length;
        int max_sum=nums[0];
        int pre=0;
        for(int i=0;i<len;i++){
            pre=Math.max(pre+nums[i],nums[i]);
            max_sum=Math.max(pre,max_sum);
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int[]nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(maxSubArray(nums));
    }
}
