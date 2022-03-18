package dyn_pro;

public class canPartition1 {
    public static boolean canPartition1(int[]nums){
        int sum=0;
        for(int num:nums)
            sum+=num;
        if((sum&1)==1)
            return false;
        int cap=sum>>1;
        int[]dp=new int[cap+1];//dp[i][j]表示前i个元素中和等与j的方案
        dp[0]=1;
        for(int i=1;i<=nums.length;i++){
            for(int j=cap;j>=0;j--){
                if(j>=nums[i-1])
                    dp[j]+=dp[j-nums[i-1]];
            }
        }
        if(dp[cap]>0)
            return true;
        return false;
    }

    //    采用位运算
    public static boolean canPartition2(int[]nums){
        int sum=0;
        for(int num:nums)
            sum+=num;
        if((sum&1)==1)
            return false;
        int len=sum>>1;
        byte[] bits=new byte[len+1];
        bits[0]=1;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int size=len-num;
            for(int j=size;j>=0;j--)
                bits[j+num]|=bits[j];
            if((bits[len]&1)!=0)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[]nums={4,3,2,1};
        System.out.println(canPartition1(nums));
    }
}
