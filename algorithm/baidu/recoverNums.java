package baidu;

import java.util.Arrays;

public class recoverNums {
    public static int recoverNums(long[]nums){
        int n=nums.length;
        Arrays.sort(nums);
        int idx=0;
        int k=0;
        long max=0;
        while(true){
            for(int i=0;i<n;i++){
                if(nums[i]>=n)
                    break;
                if(i==n-1)
                    return k;
            }
            for(int i=0;i<n;i++){
                if(nums[i]>max){
                    max=nums[i];
                    idx=i;
                }
            }
            k+=max/n;
            for(int i=0;i<n;i++)
                nums[i]=max/n;
            nums[idx]=max%n;
        }
    }

    public static void main(String[] args) {
        long[]nums={1,0,3};
        System.out.println(recoverNums(nums));
    }
}
