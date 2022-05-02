package DoublePointers;
//����ˮ
//���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
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
