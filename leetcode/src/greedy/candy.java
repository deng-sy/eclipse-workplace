package greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

//老师想给孩子们分发糖果，有N个孩子站成了一条直线，老师会根据每个孩子的表现，预
//先给他们评分。
//你需要按照以下要求，帮助老师给这些孩子分发糖果：
//每个孩子至少分配到1个糖果。
//评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
//那么这样下来，老师至少需要准备多少颗糖果呢？
public class candy {
    public static int[] candy(int[]nums){
        int length=nums.length;
        int[]cnt=new int[length];
        Arrays.fill(cnt,1);
        for(int i=1;i<length;i++){
            if(nums[i]>nums[i-1])
                cnt[i]=cnt[i-1]+1;
        }
        System.out.println(Arrays.toString(cnt));
        int total=cnt[length-1];
        for(int i=length-1;i>0;i--){
            if(nums[i-1]>nums[i])
                cnt[i-1]=Math.max(cnt[i-1],cnt[i]+1);
            total+=cnt[i-1];
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[]nums={1,9,2,5,2,2,3,4};
        System.out.println(Arrays.toString(candy(nums)));
    }
}
