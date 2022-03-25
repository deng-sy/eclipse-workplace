package Nums_String;

import java.lang.reflect.Array;
import java.util.Arrays;

public class removeDuplicates {
    public static int removeDuplicates(int[]nums){
        if(nums.length==0)
            return 0;
        int fast=1,slow=1;
        while(fast<nums.length){
            if(nums[fast]!=nums[fast-1])
                nums[slow++]=nums[fast];
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2,3,6,6}));
    }
}
