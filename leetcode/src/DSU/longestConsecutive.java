package DSU;
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//请你设计并实现时间复杂度为?O(n) 的算法解决此问题。
import java.util.*;
public class longestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer>num_set=new HashSet<>();
        for(int num:nums)
            num_set.add(num);
        int longestStreak=0;
        for(int num:num_set){
            if(!num_set.contains(num-1)){
                int cur_num=num;
                int cur_streak=1;
                while(num_set.contains(cur_num+1)){
                    cur_num++;
                    cur_streak++;
                }
                longestStreak=Math.max(longestStreak,cur_streak);
            }
        }
        return longestStreak;
    }
}
