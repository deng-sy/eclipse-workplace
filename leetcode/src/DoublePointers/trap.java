package DoublePointers;
//接雨水
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
public class trap {
    public static int trap(int[]height){
        int ans=0,left=0,right=height.length-1;
        int leftMax=0,rightMax=0;
        while(left<right){
            System.out.print(height[left]+" "+height[right]+" ");
            leftMax=Math.max(leftMax,height[left]);
            rightMax=Math.max(rightMax,height[right]);
            if(height[left]<height[right])
                ans+=leftMax-height[left++];
            else
                ans+=rightMax-height[right--];

            System.out.print(leftMax+" "+rightMax+" ");
            System.out.println(ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
