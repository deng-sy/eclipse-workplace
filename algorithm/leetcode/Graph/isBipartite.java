package Graph;
//����ͼ ���壺����ܽ�һ��ͼ�Ľڵ㼯�Ϸָ�������������Ӽ� A �� B ����ʹͼ�е�ÿһ���ߵ������ڵ�һ������ A ���ϣ�һ������ B ���ϣ��ͽ����ͼ��Ϊ ����ͼ ��

//���ͼ�Ƕ���ͼ������ true �����򣬷��� false ��

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class isBipartite {
    int[] label;
    int[][] graph;

    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        int n = graph.length;
        label = new int[n];
        Arrays.fill(label, -1);
        for (int i = 0; i < n; i++) {
            if (label[i] == -1) {
                label[i] = 0;
                if (!dfs(i))
                    return false;
            }
        }
        System.out.println(Arrays.toString(label));
        return true;
    }

    public boolean dfs(int i) {
        for (int j : graph[i]) {
            if (label[j] == -1) {
                label[j] = 1 - label[i];
                if (!dfs(j))
                    return false;
            } else if (label[i] == label[j])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1}, {0, 3}, {3}, {1, 2}};
        System.out.print(new isBipartite().isBipartite(graph));
    }
}
