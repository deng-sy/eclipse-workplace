package zhousai;
//2385. ��Ⱦ��������Ҫ����ʱ��
//����һ�ö������ĸ��ڵ� root ���������нڵ��ֵ ������ͬ �������һ������ start ���ڵ� 0 ���ӣ���Ⱦ �����ֵΪ start �Ľڵ㿪ʼ������
//
//ÿ���ӣ�����ڵ���������ȫ���������ͻᱻ��Ⱦ��
//
//�ڵ��ǰ��û�и�Ⱦ��
//�ڵ���һ���Ѹ�Ⱦ�ڵ����ڡ�
//���ظ�Ⱦ��������Ҫ�ķ�������

import java.util.*;


public class amountOfTime {
    int size, start, node_start;
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public int amountOfTime(TreeNode root, int start) {
        int ans = 0;
        this.start = start;
        dfs(root, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node_start);
        boolean[] vis = new boolean[size];
        vis[node_start] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            while (size-- > 0) {
                int from = queue.poll();
                for (int to : list.get(from)) {
                    if (vis[to])
                        continue;
                    flag = true;
                    queue.offer(to);
                    vis[to] = true;
                }
            }
            if (flag)
                ans++;
        }
        return ans;
    }

    private void dfs(TreeNode root, int parent) {
        if (root == null)
            return;
        list.add(new ArrayList<>());
        if (root.val == start)
            node_start = size;
        root.val = size;
        if (parent >= 0) {
            list.get(parent).add(size);
            list.get(size).add(parent);
        }
        size++;
        dfs(root.left, root.val);
        dfs(root.right, root.val);

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.constructTree(new Integer[]{1, 2, null, 3, null, 4, null, 5});
        int start = 3;
        System.out.println(new amountOfTime().amountOfTime(root, start));
    }
}
