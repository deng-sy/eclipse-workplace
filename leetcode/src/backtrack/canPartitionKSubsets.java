package backtrack;

import java.util.Arrays;

public class canPartitionKSubsets {
//    ����һ����������nums��һ��������k���ҳ��Ƿ��п��ܰ��������ֳ�k ���ǿ��Ӽ������ܺͶ����
//1.����
    public static boolean canPartitionKSubsets1(int[]nums,int k){
        int total=0;
        for(int num:nums)
            total+=num;
        if(total==0||total%k!=0)
            return false;
        Arrays.sort(nums);
        return backtrack(nums,nums.length-1,total/k,new int[k]);
    }
    private static boolean backtrack(int[]nums,int idx,int target,int[]size){
        if(idx==-1){
            for(int i=1;i<size.length;i++){
                if(size[i]!=size[i-1])
                    return false;
            }
            return true;
        }

//        {1,5,3,3}
        for(int i=0;i<size.length;i++){
            System.out.println("i:"+i);
            System.out.println("size[i]:"+size[i]);
            System.out.println("idx:"+idx);
            System.out.println("nums[idx]:"+nums[idx]);
            System.out.println();
            if(size[i]+nums[idx]>target||(i>0&&size[i]==size[i-1]))
                continue;
            size[i]+=nums[idx];
            if(backtrack(nums,idx-1,target,size))
                return true;
            size[i]-=nums[idx];
            System.out.println(Arrays.toString(size));
        }


        return false;
    }
//2.״̬ѹ��dp
    public static boolean canPartitionKSubsets2(int[]nums,int k){
        int total=0;
        for(int num:nums)
            total+=num;
        if(total==0||total%k!=0)
            return false;
        Arrays.sort(nums);
        int len=nums.length;
        int size=1<<len;
        int target=total/k;
        boolean[]dp=new boolean[size];
        dp[0]=true;
        int[]currentSum=new int[size];
        for(int i=0;i<size;i++){
            if(!dp[i])
                continue;
            for(int j=0;j<len;j++){
//                ��i�Ķ����Ƶ�jλ�Ƿ�Ϊ1��ʾ�Ƿ����num[j]Ԫ��
                if((i&(1<<j))!=0)
                    continue;
                int next=i|(1<<j);
                if(dp[next])
                    continue;
                if((currentSum[i]%target)+nums[j]<=target){
                    currentSum[next]=currentSum[i]+nums[j];
                    dp[next]=true;
                }
                else
                    break;
            }
        }
        System.out.println(Arrays.toString(currentSum));
        return dp[size-1];
    }
    public static void main(String[] args) {
        int[]nums={1,7,2,6};
        int k=2;
        System.out.println(canPartitionKSubsets2(nums,k));
    }
}
