package zhousai;

import java.util.*;

//给你一个 正 整数 k ，同时给你：
//
//一个大小为 n 的二维整数数组 rowConditions ，其中 rowConditions[i] = [abovei, belowi] 和
//一个大小为 m 的二维整数数组 colConditions ，其中 colConditions[i] = [lefti, righti] 。
//两个数组里的整数都是 1 到 k 之间的数字。
//
//你需要构造一个 k x k 的矩阵，1 到 k 每个数字需要 恰好出现一次 。剩余的数字都是 0 。
//
//矩阵还需要满足以下条件：
//
//对于所有 0 到 n - 1 之间的下标 i ，数字 abovei 所在的 行 必须在数字 belowi 所在行的上面。
//对于所有 0 到 m - 1 之间的下标 i ，数字 lefti 所在的 列 必须在数字 righti 所在列的左边。
//返回满足上述要求的 任意 矩阵。如果不存在答案，返回一个空的矩阵。
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
