package DoublePointers;

import java.util.Arrays;

//����һ��������ɫ����ɫ����ɫ��һ��n��Ԫ�ص����飬ԭ�ض����ǽ�������ʹ����
//ͬ��ɫ��Ԫ�����ڣ������պ�ɫ����ɫ����ɫ˳�����С�
//�����У�����ʹ������0��1��2�ֱ��ʾ��ɫ����ɫ����ɫ��
public class sortColors {
    public static void sortColors(int[]nums){
        int left=0,right=nums.length-1;
        int idx=0;
        while(idx<=right){
            if(nums[idx]==0)
                swap(nums,left++,idx++);
            else if(nums[idx]==1)
                idx++;
            else if(nums[idx]==2)
                swap(nums,right--,idx);

        }
    }
    //    �������ʽʵ�ֽ���
    private static void swap(int[]array,int i,int j){
        if(i!=j){
            array[i]^=array[j];
            array[j]^=array[i];
            array[i]^=array[j];
        }
    }
    public static void main(String[] args) {
        int[]nums={2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
