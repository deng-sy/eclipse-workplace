package Stack_Queue_Heap;

import java.util.*;

//����һ������Ϊ n ����������?height?����?n?�����ߣ��� i ���ߵ������˵���?(i, 0)?��?(i, height[i])?��
//�ҳ����е������ߣ�ʹ��������?x?�Ṳͬ���ɵ�����������������ˮ��
//�����������Դ�������ˮ����
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
