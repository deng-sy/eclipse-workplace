package hard;

import java.util.Arrays;
import java.util.Stack;

public class largestRectangleArea {
    public static int largestRectangleArea(int[] heights) {
//�����Ǹ��������� heights?�������е�����������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��
//���ڸ���״ͼ�У��ܹ����ճ����ľ��ε���������

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
