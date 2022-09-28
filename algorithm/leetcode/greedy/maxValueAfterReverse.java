package greedy;

//给你一个整数数组?nums 。「数组值」定义为所有满足?0 <= i < nums.length-1?的?|nums[i]-nums[i+1]|?的和。

//你可以选择给定数组的任意子数组，并将该子数组翻转。但你只能执行这个操作?一次 。

//请你找到可行的最大 数组值?。

public class maxValueAfterReverse {
    public int maxValueAfterReverse(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int sum=0,res=0;
        for(int i=0;i<nums.length-1;i++){
            sum+=Math.abs(nums[i]-nums[i+1]);
            min=Math.min(min,Math.max(nums[i],nums[i+1]));
            max=Math.max(max,Math.min(nums[i],nums[i+1]));

        }
        res=Math.max(sum,sum+2*(max-min));
        for(int i=1;i<nums.length-1;i++){
            res=Math.max(res,sum+Math.abs(nums[0]-nums[i+1])-Math.abs(nums[i]-nums[i+1]));
            res=Math.max(res,sum+Math.abs(nums[nums.length-1]-nums[i-1])-Math.abs(nums[i]-nums[i-1]));
        }
        return res;
    }
}
