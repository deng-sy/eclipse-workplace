package zhousai;

import java.util.*;

//6178. �������Ϊ��������
//����һ����ά�������� intervals ������ intervals[i] = [lefti, righti] ��ʾ �� ���� [lefti, righti] ��
//����Ҫ�� intervals ����Ϊһ�����߶������ �� ��ÿ������ ֻ ����һ���飬��ͬһ������������������ ���ཻ ��
//���㷵�� ���� ��Ҫ���ֳɶ��ٸ��顣
//����������串�ǵķ�Χ���ص�����������һ���������֣�����ô���ǳ������������� �ཻ �ġ��ȷ�˵���� [1, 5] �� [5, 8] �ཻ��
public class minGroups {
    //    ���
    public int minGroups1(int[][] intervals) {
        int[] cnt = new int[1000005];
        for (int[] interval : intervals) {
            cnt[interval[0]]++;
            cnt[interval[1] + 1]--;
        }
        int ans = 1;
        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];
            ans = Math.max(ans, cnt[i]);
        }
        return ans;
    }

    //��
    public int minGroups2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        for (int[] interval : intervals) {
            int left = interval[0], right = interval[1];
            if (!pq.isEmpty() && pq.peek() < left) {
                pq.poll();
            }
            pq.offer(right);
        }
        return pq.size();
    }

}
