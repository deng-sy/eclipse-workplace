package zhousai;

import java.util.*;

public class maximumSum {
    public int maximumSum(int[] nums) {
        Arrays.sort(nums);
        int ans=-1;
        Map<Integer,List<Integer>>map=new HashMap<>();
        for(int i=nums.length-1;i>=0;i--){
            int num=nums[i];
            int bitSum=getBitSum(num);
            if(map.get(bitSum)==null)
                map.put(bitSum,new ArrayList<>());
            if(map.get(bitSum).size()<2)
                map.get(bitSum).add(num);
            if(map.get(bitSum).size()==2){
                ans=Math.max(ans,map.get(bitSum).get(0)+map.get(bitSum).get(1));
                map.get(bitSum).add(0);
            }
        }
        return ans;
    }
    private int getBitSum(int num){
        int ans=0;
        while(num>0){
            ans+=num%10;
            num/=10;
        }
        return ans;
    }
}
