package DSU;
//����һ��δ������������� nums ���ҳ���������������У���Ҫ������Ԫ����ԭ�������������ĳ��ȡ�
//������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ?O(n) ���㷨��������⡣
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
