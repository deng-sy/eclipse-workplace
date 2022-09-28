package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//����һ�������������������nums����һ��������n����[1, n]������ѡȡ��������ֲ� �� �� nums �� ��
// ʹ �� [1,n] �� �� �� �� �� �� �� �� �� �� �� �� nums �� ĳ �� �� �� �� �� �� �� ��ʾ���������������Ҫ���������Ҫ��������ָ�����
public class minPatches {
    public static List<Integer> minPatches(int[]nums,int n){
        int total=0;
        int cnt=0,idx=0;
        List<Integer> res=new ArrayList<>();
        while(total<n){
            if(idx<nums.length&&nums[idx]<=total+1)
                total+=nums[idx++];
            else{
                res.add(total+1);
                total=total+total+1;

                cnt++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[]nums={1,5,10};
        int n=20;
        System.out.println(minPatches(nums,n));
    }
}
