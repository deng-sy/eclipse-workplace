package greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

//��ʦ��������Ƿַ��ǹ�����N������վ����һ��ֱ�ߣ���ʦ�����ÿ�����ӵı��֣�Ԥ
//�ȸ��������֡�
//����Ҫ��������Ҫ�󣬰�����ʦ����Щ���ӷַ��ǹ���
//ÿ���������ٷ��䵽1���ǹ���
//���ָ��ߵĺ��ӱ�������������λ���ӻ�ø�����ǹ���
//��ô������������ʦ������Ҫ׼�����ٿ��ǹ��أ�
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
