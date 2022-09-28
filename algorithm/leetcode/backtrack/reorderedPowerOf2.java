package backtrack;

import java.util.Arrays;

//����������N�����ǰ��κ�˳�򣨰���ԭʼ˳�򣩽�������������ע����ǰ�����ֲ���Ϊ�㡣������ǿ���ͨ��������ʽ�õ�2���ݣ�����true�����򣬷���false��
public class reorderedPowerOf2 {
    private static boolean[]vis;

    public static boolean reorderedPowerOf2(int n){
        char[]nums=Integer.toString(n).toCharArray();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        vis=new boolean[nums.length];
        return backtrack(nums,0,0);
    }

    public static boolean backtrack(char[]nums,int idx,int num){
        if(idx==nums.length){
            System.out.println(num);
            return isPowerOf2(num);
        }

        for(int i=0;i<nums.length;i++){
            if((num==0&&nums[i]=='0')||vis[i]||(i>0&&nums[i-1]==nums[i]&&vis[i-1]))
                continue;
            vis[i]=true;
            if(backtrack(nums,idx+1,num*10+nums[i]-'0'))
                return true;
            vis[i]=false;
        }
        return false;
    }
    public static boolean isPowerOf2(int n){
        return (n&(n-1))==0;
}

    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(125));
    }
}
