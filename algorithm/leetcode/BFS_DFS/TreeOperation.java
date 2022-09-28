package BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// TreeOperation.java
public class TreeOperation {
    /*
    ���Ľṹʾ����
           5
         /     \
      4           8
    /           /   \
  11          13      4
 / \                   \
7   2                   1
    */

    // ���ڻ�����Ĳ���
    public static int getTreeDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }

    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // ��֤���������Ϊ��
        if (currNode == null) return;
        // �Ƚ���ǰ�ڵ㱣�浽��ά������
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // ���㵱ǰλ�����ĵڼ���
        int currLevel = ((rowIndex + 1) / 2);
        // ���������һ�㣬�򷵻�
        if (currLevel == treeDepth) return;
        // ���㵱ǰ�е���һ�У�ÿ��Ԫ��֮��ļ������һ�е��������뵱ǰԪ�ص�������֮��ļ����
        int gap = treeDepth - currLevel - 1;

        // ������ӽ����жϣ���������ӣ����¼��Ӧ��"/"������ӵ�ֵ
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // ���Ҷ��ӽ����жϣ������Ҷ��ӣ����¼��Ӧ��"\"���Ҷ��ӵ�ֵ
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }

    public static void show(TreeNode root) {
        if (root == null) System.out.println("EMPTY!");
        // �õ��������
        int treeDepth = getTreeDepth(root);

        // ���һ�еĿ��Ϊ2�ģ�n - 1���η���3���ټ�1
        // ��Ϊ������ά����Ŀ��
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (1 << (treeDepth - 1)) * 3 + 1;
        // ��һ���ַ����������洢ÿ��λ��Ӧ��ʾ��Ԫ��
        String[][] res = new String[arrayHeight][arrayWidth];
        // ��������г�ʼ����Ĭ��Ϊһ���ո�
        for (int i = 0; i < arrayHeight; i ++) {
            for (int j = 0; j < arrayWidth; j ++) {
                res[i][j] = " ";
            }
        }

        // �Ӹ��ڵ㿪ʼ���ݹ鴦��������
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth/ 2, res, treeDepth);

        // ��ʱ���Ѿ���������Ҫ��ʾ��Ԫ�ش��浽�˶�ά�����У�����ƴ�Ӳ���ӡ����
        for (String[] line: res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i ++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2: line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }

//    ǰ������ݹ�
    public static void preOrder(TreeNode root){
        if(root==null){return;}
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
//    ��������ݹ�
    public static void midOrder(TreeNode root){
        if(root==null){return;}
        midOrder(root.left);
        System.out.print(root.val+" ");
        midOrder(root.right);
    }
//    ��������ݹ�
    public static void aftOrder(TreeNode root){
        if(root==null){return;}
        aftOrder(root.left);
        aftOrder(root.right);
        System.out.print(root.val+" ");
    }

//    �������(������ȷǵݹ���)
    public static List<List<Integer>> levelOrderBFS(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    if (root == null) {
        return ret;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        List<Integer> level = new ArrayList<>();
        int currentLevelSize = queue.size();
        for (int i = 1; i <= currentLevelSize; ++i) {
            TreeNode node = queue.poll();
            level.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        ret.add(level);
    }

    return ret;
    }

//    ���������������ȵݹ�����
    public static List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }

    public static void levelHelper(List<List<Integer>> list, TreeNode root, int level) {
        //�߽������ж�
        if (root == null)
            return;
        //level��ʾ���ǲ��������level >= list.size()��˵������һ���ˣ�����
        //Ҫ�Ȱ���һ���list��ʼ������ֹ����add��ʱ����ֿ�ָ���쳣
        if (level >= list.size()) {
            list.add(new ArrayList<>());
        }
        //level��ʾ���ǵڼ��㣬������ʵ��ڼ��㣬���ǾͰ����ݼ��뵽�ڼ���
        list.get(level).add(root.val);
        //��ǰ�ڵ������֮����ʹ�õݹ�ķ�ʽ�ֱ���ʵ�ǰ�ڵ�������ӽڵ�
        levelHelper(list, root.left, level + 1);
        levelHelper(list, root.right, level + 1);
    }



    public static void main(String[] args) {
        Integer nums[] ={5,4,8,11,null,13,4,7,2,null,null,null,1};
        // ���ݸ��������鴴��һ����
        TreeNode root = ConstructTree.constructTree(nums);
        // ���ոմ���������ӡ����

        TreeOperation.show(root);
        System.out.print("ǰ�������");
        preOrder(root);
        System.out.println();
        System.out.print("���������");
        midOrder(root);
        System.out.println();
        System.out.print("���������");
        aftOrder(root);
        System.out.println();
        System.out.print("���������");
        System.out.print(levelOrderBFS(root));
    }

}

