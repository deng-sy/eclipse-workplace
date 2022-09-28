package zhousai;

import java.util.*;

class numberOfPairs {
    public int[] numberOfPairs(int[] nums) {
        int cnt=0,left=0;
        Map<Integer,Integer> map=new HashMap();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int value:map.values()){
            cnt+=value/2;
            left+=value%2;
        }
        return new int[]{cnt,left};
    }
}
