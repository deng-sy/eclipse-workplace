package zhousai;
//2368. ���������¿ɵ���ڵ����Ŀ
//����һ���� n ���ڵ���ɵ����������ڵ��Ŵ� 0 �� n - 1 ������ n - 1 ���ߡ�
//
//����һ����ά�������� edges ������Ϊ n - 1 ������ edges[i] = [ai, bi] ��ʾ���нڵ� ai �� bi ֮�����һ���ߡ������һ���������� restricted ��ʾ ���� �ڵ㡣
//
//�ڲ��������޽ڵ��ǰ���£���������Դӽڵ� 0 ����� ��� �ڵ���Ŀ��
//
//ע�⣬�ڵ� 0 �� ����Ϊ���޽ڵ㡣

import java.util.*;

public class reachableNodes {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        HashSet<Integer> banned = new HashSet<>();
        for (int node : restricted) {
            banned.add(node);
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (banned.contains(x) || banned.contains(y))
                continue;
            list.get(x).add(y);
            list.get(y).add(x);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int from = queue.poll();
                for (int to : list.get(from)) {
                    if (!set.contains(to))
                        queue.offer(to);
                    set.add(to);
                }
            }
        }
        return set.size();
    }
}
