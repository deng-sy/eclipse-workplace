package zhousai;

import java.util.*;

public class minOperations {
    public static int minOperations(int[] nums, int[] numsDivide) {
        Set<Integer>set=new TreeSet<>();
        int min=Integer.MAX_VALUE;
        for(int num:numsDivide){
            set.add(num);
            min=Math.min(min,num);
        }
        int gcd=min;
        for(int num:set){
            gcd=Math.min(gcd,getGCD(min,num));
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(gcd%nums[i]==0)
                return i;
        }
        return -1;

    }
    private static int getGCD(int x,int y){
        while(x>0){
            int tmp=x;
            x=y%x;
            y=tmp;
        }
        return y;
    }

    public static void main(String[] args) {
        int[]nums={4,3,6};
        int[]divide={8,2,6,10};
        System.out.println(minOperations(nums,divide));
    }
}
