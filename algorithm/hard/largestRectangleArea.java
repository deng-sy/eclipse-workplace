package hard;

import java.util.Arrays;
import java.util.Stack;

public class largestRectangleArea {
    public static int largestRectangleArea(int[] heights) {
//给定非负整数数组 heights?，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//求在该柱状图中，能够勾勒出来的矩形的最大面积。

        int n=heights.length;
        Stack<Integer>stack=new Stack<>();
        int[]left=new int[n],right=new int[n];
        Arrays.fill(right,n);
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                right[stack.peek()]=i;
                stack.pop();
            }
            left[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int ans=0;
        for(int i=0;i<n;i++){
            int area=(right[i]-left[i]-1)*heights[i];
            System.out.println(area);
            ans=Math.max(ans,area);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]height={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(height));
    }
}
