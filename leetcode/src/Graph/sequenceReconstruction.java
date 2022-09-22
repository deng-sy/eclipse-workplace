package Graph;

import java.util.*;
//请判断原始的序列?org?是否可以从序列集?seqs?中唯一地 重建?。
//序列?org?是 1 到 n 整数的排列，其中 1 ≤ n ≤ 104。重建?是指在序列集 seqs 中构建最短的公共超序列，即??seqs?中的任意序列都是该最短序列的子序列。

//算法：拓扑排序

public class sequenceReconstruction {
    boolean[] vis;
    int vis_num = 0;
    List<List<Integer>> edges;
    int n;
    boolean hasCycle = false;
    boolean isSeq = false;
    int[] nums;

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs.size() == 0)
            return false;
        n = org.length;
        edges = new ArrayList<>();
        int[] indegs = new int[n];
        vis = new boolean[n];
        nums = org;
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                if (seq.get(i) - 1 >= n || seq.get(i) - 1 < 0)
                    return false;
                if (i > 0) {
                    int from = seq.get(i - 1) - 1, to = seq.get(i) - 1;
                    if (from >= n || to >= n || from < 0 || to < 0)
                        return false;
                    if (!edges.get(from).contains(to)) {
                        edges.get(from).add(to);
                        indegs[to]++;
                    }
                }
            }
        }


        int start = -1;
        for (int i = 0; i < n; i++) {
            if (indegs[i] == 0) {
                if (start == -1)
                    start = i;
                else
                    return false;
            }
        }
        if (start == -1)
            return false;
        vis[start] = true;
        dfs(start);
        System.out.println(isSeq + " " + hasCycle);
        if (isSeq && (!hasCycle))
            return true;
        return false;
    }

    public void dfs(int i) {
//        如果对应元素不一样
        if (nums[vis_num] != i + 1)
            return;
        if (vis_num == n - 1 && edges.get(i).size() == 0 && (!hasCycle))
            isSeq = true;
        for (int j : edges.get(i)) {
//            如果有环
            if (vis[j]) {
                hasCycle = true;
                break;
            }
            vis[j] = true;
            vis_num++;
            dfs(j);
            if (hasCycle)
                break;
            vis[j] = false;
            vis_num--;
        }
        return;
    }

    public static void main(String[] args) {
        int[] org = {1};
        List<List<Integer>> seqs = new ArrayList<>();
        int[][] visits = {{1}, {1}, {1}};
        int i = 0;
        for (int[] visit : visits) {
            seqs.add(new ArrayList<>());
            for (int num : visit) {
                seqs.get(i).add(num);
            }
            i++;
        }

        System.out.println(new sequenceReconstruction().sequenceReconstruction(org, seqs));
    }
}
