package zhousai;

import java.util.*;

//����һ�� �� ���� k ��ͬʱ���㣺
//
//һ����СΪ n �Ķ�ά�������� rowConditions ������ rowConditions[i] = [abovei, belowi] ��
//һ����СΪ m �Ķ�ά�������� colConditions ������ colConditions[i] = [lefti, righti] ��
//������������������� 1 �� k ֮������֡�
//
//����Ҫ����һ�� k x k �ľ���1 �� k ÿ��������Ҫ ǡ�ó���һ�� ��ʣ������ֶ��� 0 ��
//
//������Ҫ��������������
//
//�������� 0 �� n - 1 ֮����±� i ������ abovei ���ڵ� �� ���������� belowi �����е����档
//�������� 0 �� m - 1 ֮����±� i ������ lefti ���ڵ� �� ���������� righti �����е���ߡ�
//������������Ҫ��� ���� ������������ڴ𰸣�����һ���յľ���
public class buildMatrix {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] ans = new int[k][k];
        List<List<Integer>> rows = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            rows.add(new ArrayList<>());
        }
        int[] row_indigs = new int[k];
        for (int[] rowCondition : rowConditions) {
            int above = rowCondition[0] - 1, below = rowCondition[1] - 1;
            rows.get(above).add(below);
            row_indigs[below]++;
        }
        Queue<Integer> row_queue = new LinkedList<>();
        int[] row_pos = new int[k];
        int row_cnt = 0;
        for (int i = 0; i < k; i++) {
            if (row_indigs[i] == 0)
                row_queue.offer(i);
        }
        while (!row_queue.isEmpty()) {
            int from = row_queue.poll();
            row_pos[from] = row_cnt++;
            for (int to : rows.get(from)) {
                row_indigs[to]--;
                if (row_indigs[to] == 0)
                    row_queue.offer(to);
            }
        }
        for (int i = 0; i < k; i++) {
            if (row_indigs[i] > 0)
                return new int[0][0];
        }


        List<List<Integer>> cols = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            cols.add(new ArrayList<>());
        }
        int[] col_indigs = new int[k];
        for (int[] colCondition : colConditions) {
            int left = colCondition[0] - 1, right = colCondition[1] - 1;
            cols.get(left).add(right);
            col_indigs[right]++;
        }

        Queue<Integer> col_queue = new LinkedList<>();
        int[] col_pos = new int[k];
        int col_cnt = 0;
        for (int i = 0; i < k; i++) {
            if (col_indigs[i] == 0)
                col_queue.offer(i);
        }
        while (!col_queue.isEmpty()) {
            int from = col_queue.poll();
            col_pos[from] = col_cnt++;
            for (int to : cols.get(from)) {
                col_indigs[to]--;
                if (col_indigs[to] == 0)
                    col_queue.offer(to);
            }
        }

        for (int i = 0; i < k; i++) {
            if (col_indigs[i] > 0)
                return new int[0][0];
        }
        for (int i = 0; i < k; i++) {
            ans[row_pos[i]][col_pos[i]] = i + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int k = 3;
        int[][] rowConditions = {{1, 2}, {3, 2}}, colConditions = {{2, 1}, {3, 2}};
        System.out.print(Arrays.deepToString(new buildMatrix().buildMatrix(k, rowConditions, colConditions)));
    }
}
