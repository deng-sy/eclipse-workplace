package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个已排序的正整数数组nums，和一个正整数n。从[1, n]区间内选取任意个数字补 充 到 nums 中 ，
// 使 得 [1,n] 区 间 内 的 任 何 数 字 都 可 以 用 nums 中 某 几 个 数 字 的 和 来 表示。请输出满足上述要求的最少需要补充的数字个数。
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
