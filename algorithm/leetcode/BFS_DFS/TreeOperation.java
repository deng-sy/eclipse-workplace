package BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// TreeOperation.java
public class TreeOperation {
    /*
    树的结构示例：
           5
         /     \
      4           8
    /           /   \
  11          13      4
 / \                   \
7   2                   1
    */

    // 用于获得树的层数
    public static int getTreeDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }

    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) return;
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }

    public static void show(TreeNode root) {
        if (root == null) System.out.println("EMPTY!");
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (1 << (treeDepth - 1)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i ++) {
            for (int j = 0; j < arrayWidth; j ++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth/ 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
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

//    前序遍历递归
    public static void preOrder(TreeNode root){
        if(root==null){return;}
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
//    中序遍历递归
    public static void midOrder(TreeNode root){
        if(root==null){return;}
        midOrder(root.left);
        System.out.print(root.val+" ");
        midOrder(root.right);
    }
//    后序遍历递归
    public static void aftOrder(TreeNode root){
        if(root==null){return;}
        aftOrder(root.left);
        aftOrder(root.right);
        System.out.print(root.val+" ");
    }

//    层序遍历(广度优先非递归解决)
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

//    层序遍历（深度优先递归解决）
    public static List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }

    public static void levelHelper(List<List<Integer>> list, TreeNode root, int level) {
        //边界条件判断
        if (root == null)
            return;
        //level表示的是层数，如果level >= list.size()，说明到下一层了，所以
        //要先把下一层的list初始化，防止下面add的时候出现空指针异常
        if (level >= list.size()) {
            list.add(new ArrayList<>());
        }
        //level表示的是第几层，这里访问到第几层，我们就把数据加入到第几层
        list.get(level).add(root.val);
        //当前节点访问完之后，再使用递归的方式分别访问当前节点的左右子节点
        levelHelper(list, root.left, level + 1);
        levelHelper(list, root.right, level + 1);
    }



    public static void main(String[] args) {
        Integer nums[] ={5,4,8,11,null,13,4,7,2,null,null,null,1};
        // 根据给定的数组创建一棵树
        TreeNode root = ConstructTree.constructTree(nums);
        // 将刚刚创建的树打印出来

        TreeOperation.show(root);
        System.out.print("前序遍历：");
        preOrder(root);
        System.out.println();
        System.out.print("中序遍历：");
        midOrder(root);
        System.out.println();
        System.out.print("后序遍历：");
        aftOrder(root);
        System.out.println();
        System.out.print("层序遍历：");
        System.out.print(levelOrderBFS(root));
    }

}

