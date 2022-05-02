package meituan;

import java.util.*;

public class Medium2 {
    static PriorityQueue<Integer>q1=new PriorityQueue<>(Comparator.reverseOrder()),q2=new PriorityQueue<>();
//    q1����С��һ�룬q2���ô��һ�룬����q2.size()>=q1.size()+1 ͨ������q2�е���Сֵ����ȡ��λ��
    public static void init(){
        while(q1.size()>0)
            q1.poll();
        while(q2.size()>0)
            q2.poll();
    }
    public static void add(int now){
        if(q2.size()==0){
            q2.offer(now);
            return;
        }
        if(now>=q2.peek()){
            q2.offer(now);
            if(q2.size()>q1.size()+1)
                q1.offer(q2.poll());
        }else{
            q1.offer(now);
            if(q1.size()>q2.size())
                q2.offer(q1.poll());
        }
    }
    public static void main(String[] args) {
        int[]nums={0,4,3,1};
        int n=nums.length-1;
        long ans=0;
        for(int i=1;i<=n;i++){
            init();
            add(nums[i]);
            ans+=nums[i];
            for(int j=i+1;j<=n;j++){
                add(nums[j]);
                if((j-i+1)%2==1){
                    ans+=q2.peek();
                }

            }
        }
        System.out.println(ans);

    }
}
