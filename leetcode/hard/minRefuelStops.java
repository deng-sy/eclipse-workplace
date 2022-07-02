package hard;
//������������ʻ��Ŀ�ĵأ���Ŀ�ĵ�λ�ڳ���λ�ö��� target?Ӣ�ﴦ��
//��;�м���վ��ÿ��?station[i]?����һ������վ����λ�ڳ���λ�ö���?station[i][0]?Ӣ�ﴦ��������?station[i][1]?�����͡�
//����������������������޵ģ����������?startFuel?��ȼ�ϡ���ÿ��ʻ 1 Ӣ��ͻ��õ� 1 �����͡�
//�������������վʱ��������ͣ�������ͣ����������ʹӼ���վת�Ƶ������С�
//Ϊ�˵���Ŀ�ĵأ���������Ҫ����ͼ��ʹ����Ƕ��٣�����޷�����Ŀ�ĵأ��򷵻� -1 ��
//ע�⣺��������������վʱʣ��ȼ��Ϊ 0������Ȼ������������͡������������Ŀ�ĵ�ʱʣ��ȼ��Ϊ 0����Ȼ��Ϊ���Ѿ�����Ŀ�ĵء�

import java.util.Comparator;
import java.util.PriorityQueue;

public class minRefuelStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((o1, o2) -> o2-o1);
        int n=stations.length;
        int pre=0,left=startFuel;
        int ans=0;
        for(int i=0;i<=n;i++){
            int cur=i<n?stations[i][0]:target;
            left-=cur-pre;
            while(left<0&&!pq.isEmpty()){
                left+=pq.poll();
                ans++;
            }
            if(left<0)
                return -1;
            if(i<n){
                pq.offer(stations[i][1]);
                pre=cur;
            }

        }
        return ans;
    }
}
