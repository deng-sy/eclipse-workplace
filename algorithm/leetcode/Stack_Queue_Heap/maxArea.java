package Stack_Queue_Heap;

import java.util.*;

//给定一个长度为 n 的整数数组?height?。有?n?条垂线，第 i 条线的两个端点是?(i, 0)?和?(i, height[i])?。
//找出其中的两条线，使得它们与?x?轴共同构成的容器可以容纳最多的水。
//返回容器可以储存的最大水量。
public class maxArea {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0, right = n - 1;
        int ans = 0;
        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            ans = Math.max(ans, area);
            if (heights[left] <= heights[right])
                left++;
            else
                right--;
        }
        return ans;
    }

}
