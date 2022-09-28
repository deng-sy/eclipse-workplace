package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class threeSum {
//    ���� �÷������Ӷ�̫�߻ᳬʱ
    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>res=new ArrayList();
        dfs(res,new ArrayList(),nums,0,0);
        return res;
    }
    private static void dfs(List<List<Integer>>res,List<Integer>tmp,int[]nums,int sum,int start){
        if(tmp.size()==3&&sum==0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i]==nums[i-1])
                continue;
            tmp.add(nums[i]);
            dfs(res,tmp,nums,sum+nums[i],i+1);
            tmp.remove(tmp.size()-1);
        }
    }
//   ˫ָ��
public static List<List<Integer>> threeSum2(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    // ö�� a
    for (int first = 0; first < n; ++first) {
        // ��Ҫ����һ��ö�ٵ�������ͬ
        if (first > 0 && nums[first] == nums[first - 1]) {
            continue;
        }
        // c ��Ӧ��ָ���ʼָ����������Ҷ�
        int third = n - 1;
        int target = -nums[first];
        // ö�� b
        for (int second = first + 1; second < n; ++second) {
            // ��Ҫ����һ��ö�ٵ�������ͬ
            if (second > first + 1 && nums[second] == nums[second - 1]) {
                continue;
            }
            // ��Ҫ��֤ b ��ָ���� c ��ָ������
            while (second < third && nums[second] + nums[third] > target) {
                --third;
            }
            // ���ָ���غϣ����� b ����������
            // �Ͳ��������� a+b+c=0 ���� b<c �� c �ˣ������˳�ѭ��
            if (second == third) {
                break;
            }
            if (nums[second] + nums[third] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[first]);
                list.add(nums[second]);
                list.add(nums[third]);
                ans.add(list);
            }
        }
    }
    return ans;
}
    public static void main(String[] args) {
        System.out.println(threeSum1(new int[]{-1,0,1,2,-1,-4}));
    }
}
