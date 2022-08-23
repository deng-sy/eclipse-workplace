package zhousai;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//����һ���������� nums ��һ�� �� ���� k �������ѡ���������һ ������ ���Ҷ���ȫ��Ԫ����͡�
//
//����� �� k ��� ����Ϊ�����Ի�õĵ� k �� ��� �����кͣ������к���������ظ���
//
//��������� �� k ��� ��
//
//��������һ����������������ɾ��ĳЩ��ɾ��Ԫ���������������飬���������̲��ı�ʣ��Ԫ�ص�˳��
//
//ע�⣺�������еĺ����� 0 ��
public class kSum {
    public long kSum(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> (int) (o2[0] - o1[0]));
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num < 0)
                nums[i] = -num;
            else
                sum += num;
        }
        Arrays.sort(nums);
        pq.offer(new long[]{sum, 0});
        while (--k > 0) {
//            System.out.println(pq.peek()[0]);
            long[] pair = pq.poll();
            long num = pair[0], idx = pair[1];
            if (idx == n)
                continue;
            pq.offer(new long[]{num - nums[(int) idx], idx + 1});
            if (idx > 0)
                pq.offer(new long[]{num - nums[(int) idx] + nums[(int) idx - 1], idx + 1});
        }
        return pq.peek()[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, -2};
        int k = 5;
        System.out.println(new kSum().kSum(nums, k));
    }
}
