package greedy;

//����һ����������?nums ��������ֵ������Ϊ��������?0 <= i < nums.length-1?��?|nums[i]-nums[i+1]|?�ĺ͡�

//�����ѡ�������������������飬�����������鷭ת������ֻ��ִ���������?һ�� ��

//�����ҵ����е���� ����ֵ?��

public class maxValueAfterReverse {
    public int maxValueAfterReverse(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int sum=0,res=0;
        for(int i=0;i<nums.length-1;i++){
            sum+=Math.abs(nums[i]-nums[i+1]);
            min=Math.min(min,Math.max(nums[i],nums[i+1]));
            max=Math.max(max,Math.min(nums[i],nums[i+1]));

        }
        res=Math.max(sum,sum+2*(max-min));
        for(int i=1;i<nums.length-1;i++){
            res=Math.max(res,sum+Math.abs(nums[0]-nums[i+1])-Math.abs(nums[i]-nums[i+1]));
            res=Math.max(res,sum+Math.abs(nums[nums.length-1]-nums[i-1])-Math.abs(nums[i]-nums[i-1]));
        }
        return res;
    }
}
