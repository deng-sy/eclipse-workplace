package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class threeSum {
//    回溯 该方法复杂度太高会超时
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
//   双指针
public static List<List<Integer>> threeSum2(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    // 枚举 a
    for (int first = 0; first < n; ++first) {
        // 需要和上一次枚举的数不相同
        if (first > 0 && nums[first] == nums[first - 1]) {
            continue;
        }
        // c 对应的指针初始指向数组的最右端
        int third = n - 1;
        int target = -nums[first];
        // 枚举 b
        for (int second = first + 1; second < n; ++second) {
            // 需要和上一次枚举的数不相同
            if (second > first + 1 && nums[second] == nums[second - 1]) {
                continue;
            }
            // 需要保证 b 的指针在 c 的指针的左侧
            while (second < third && nums[second] + nums[third] > target) {
                --third;
            }
            // 如果指针重合，随着 b 后续的增加
            // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
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
